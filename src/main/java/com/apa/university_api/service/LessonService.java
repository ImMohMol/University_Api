package com.apa.university_api.service;

import com.apa.university_api.model.Lesson;
import com.apa.university_api.model.Response;
import com.apa.university_api.model.dto.lesson.LessonDTO;
import com.apa.university_api.model.dto.mapper.LessonMapper;
import com.apa.university_api.model.dto.mapper.Mapper;
import com.apa.university_api.repository.ILessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LessonService {
    private final ILessonRepository lessonRepository;
    private final LessonMapper lessonMapper;
    private final Mapper mapper;

    @Autowired
    public LessonService(ILessonRepository lessonRepository, LessonMapper lessonMapper, Mapper mapper) {
        this.lessonRepository = lessonRepository;
        this.lessonMapper = lessonMapper;
        this.mapper = mapper;
    }

    public Response add(LessonDTO lessonDTO) {
        Optional<Lesson> isLessonExists = this.lessonRepository.findByName(lessonDTO.getName());
        if (isLessonExists.isPresent())
            return new Response(400, "This lesson exists can't add it again!", null);
        Lesson lesson = this.mapper.convert(lessonDTO, Lesson.class);
        Lesson savedLesson = this.lessonRepository.save(lesson);
        return new Response(200, "Lesson added successfully!", savedLesson);
    }

    public Lesson get(Long id) {
        Optional<Lesson> lesson = this.lessonRepository.findById(id);
        return lesson.orElse(null);
    }
}
