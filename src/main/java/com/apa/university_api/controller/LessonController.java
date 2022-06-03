package com.apa.university_api.controller;

import com.apa.university_api.model.Lesson;
import com.apa.university_api.model.Response;
import com.apa.university_api.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/lesson")
public class LessonController {
    private final LessonService lessonService;

    @Autowired
    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Response> add(Lesson lesson) {
        Response result = this.lessonService.add(lesson);
        if (result.getResultCode() == 200)
            return ResponseEntity.ok(result);
        return ResponseEntity.badRequest().body(result);
    }
}
