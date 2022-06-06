package com.apa.university_api.service;

import com.apa.university_api.model.Lesson;
import com.apa.university_api.model.Response;
import com.apa.university_api.model.Teacher;
import com.apa.university_api.model.dto.LessonDto;
import com.apa.university_api.repository.ILessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LessonService {
    private final ILessonRepository lessonRepository;
    private final TeacherService teacherService;

    @Autowired
    public LessonService(ILessonRepository lessonRepository, TeacherService teacherService) {
        this.lessonRepository = lessonRepository;
        this.teacherService = teacherService;
    }

    public Response add(LessonDto lesson) {
        Optional<Lesson> isLessonExists = this.lessonRepository.findByName(lesson.getName());
        if (isLessonExists.isPresent())
            return new Response(400, "This lesson exists can't add it again!", null);
        Teacher teacher = this.teacherService.get(lesson.getTeacherPersonalNumber());
        if (teacher == null)
            return new Response(400, "This teacher doesn't exists!", null);
        Lesson savingLesson = new Lesson(lesson.getName(), lesson.getGrade(), teacher, lesson.getStudents());
        Lesson savedLesson = this.lessonRepository.save(savingLesson);
        return new Response(200, "Lesson added successfully!", savedLesson);
    }
}
