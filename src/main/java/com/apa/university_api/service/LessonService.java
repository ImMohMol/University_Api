package com.apa.university_api.service;

import com.apa.university_api.model.dto.mapper.Mapper;
import com.apa.university_api.repository.ILessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
    private final ILessonRepository lessonRepository;
    private final Mapper mapper;

    @Autowired
    public LessonService(ILessonRepository lessonRepository, Mapper mapper) {
        this.lessonRepository = lessonRepository;
        this.mapper = mapper;
    }

//    public Response add(LessonDTO lessonDTO) {
//        Optional<Lesson> isLessonExists = this.lessonRepository.findByName(lessonDTO.getName());
//        if (isLessonExists.isPresent())
//            return new Response(400, "This lesson exists can't add it again!", null);
//        Lesson lesson = this.mapper.convert(lessonDTO, Lesson.class);
//        Lesson savedLesson = this.lessonRepository.save(lesson);
//        return new Response(200, "Lesson added successfully!", savedLesson);
//    }

//    public Lesson get(Long id) {
//        Optional<Lesson> lesson = this.lessonRepository.findById(id);
//        return lesson.orElse(null);
//    }
}
