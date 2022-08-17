package com.apa.university_api.model.dto.mapper;

import com.apa.university_api.model.Lesson;
import com.apa.university_api.model.dto.lesson.LessonDTO;
import org.springframework.stereotype.Component;

@Component
public class LessonMapper {
    public Lesson convertLessonDtoToLesson(LessonDTO lessonDTO) {
        Lesson lesson = new Lesson();
        lesson.setName(lessonDTO.getName());
        lesson.setGrade(lessonDTO.getGrade());
        return lesson;
    }
}
