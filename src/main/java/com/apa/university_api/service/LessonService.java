package com.apa.university_api.service;

import com.apa.university_api.model.Lesson;
import com.apa.university_api.model.Response;
import com.apa.university_api.repository.ILessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LessonService {
    private final ILessonRepository lessonRepository;

    @Autowired
    public LessonService(ILessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public Response add(Lesson lesson) {
        Optional<Lesson> isLessonExists = this.lessonRepository.findByName(lesson.getName());
        if (isLessonExists.isPresent())
            return new Response(400, "This lesson exists can't add it again!", null);
        Lesson savedLesson = this.lessonRepository.save(lesson);
        return new Response(200, "Lesson added successfully!", savedLesson);
    }
}
