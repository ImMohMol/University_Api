package com.apa.university_api.controller;

import com.apa.university_api.model.Response;
import com.apa.university_api.model.Teacher;
import com.apa.university_api.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @PostMapping(path = "/add")
    public ResponseEntity<Response> add(@RequestBody Teacher teacher) {
        Response result = this.teacherService.add(teacher);
        if (result.getResultCode() == 200)
            return ResponseEntity.ok(result);
        return ResponseEntity.badRequest().body(result);
    }
}
