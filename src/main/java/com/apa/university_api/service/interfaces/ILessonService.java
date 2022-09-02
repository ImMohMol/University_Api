package com.apa.university_api.service.interfaces;

import com.apa.university_api.model.Lesson;
import com.apa.university_api.model.Response;
import com.apa.university_api.model.dto.lesson.LessonDTO;

public interface ILessonService {
    Response add(LessonDTO lessonDTO);

    Lesson find(Long lessonId);
}
