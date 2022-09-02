package com.apa.university_api.service.implementation;

import com.apa.university_api.model.Lesson;
import com.apa.university_api.model.Response;
import com.apa.university_api.model.dto.lesson.LessonDTO;
import com.apa.university_api.model.dto.mapper.Mapper;
import com.apa.university_api.repository.ILessonRepository;
import com.apa.university_api.service.interfaces.ILessonService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LessonServiceImplementation implements ILessonService {
    private final ILessonRepository lessonRepository;
    private final Mapper mapper;

    public LessonServiceImplementation(ILessonRepository lessonRepository, Mapper mapper) {
        this.lessonRepository = lessonRepository;
        this.mapper = mapper;
    }

    @Override
    public Response add(LessonDTO lessonDTO) {
        Optional<Lesson> isLessonExists = this.lessonRepository.findByName(lessonDTO.getName());
        if (isLessonExists.isPresent())
            return new Response(400, "This lesson exists can't add it again!", null);
        Lesson lesson = this.mapper.convert(lessonDTO, Lesson.class);
        Lesson savedLesson = this.lessonRepository.save(lesson);
        return new Response(200, "Lesson added successfully!", savedLesson);
    }

    @Override
    public Lesson find(Long lessonId) {
        Optional<Lesson> lesson = this.lessonRepository.findById(lessonId);
        return lesson.orElse(null);
    }
}
