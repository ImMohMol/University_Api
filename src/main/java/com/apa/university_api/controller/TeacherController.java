package com.apa.university_api.controller;

import com.apa.university_api.model.Response;
import com.apa.university_api.model.dto.teacher.TeacherDTO;
import com.apa.university_api.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping(path = "")
    public ResponseEntity<Response> add(@RequestBody @Valid TeacherDTO teacher) {
        Response result = this.teacherService.add(teacher);
        if (result.getResultCode() == 200)
            return ResponseEntity.ok(result);
        return ResponseEntity.badRequest().body(result);
    }

    @GetMapping(path = "/students")
    public ResponseEntity<Response> getStudents(@RequestParam(name = "teacherPersonalNumber") String teacherPersonalNumber) {
        Response result = this.teacherService.getStudents(teacherPersonalNumber);
        if (result.getResultCode() == 200)
            return ResponseEntity.ok(result);
        return ResponseEntity.badRequest().body(result);
    }
}
