package com.apa.university_api.controller;

import com.apa.university_api.model.Response;
import com.apa.university_api.model.Student;
import com.apa.university_api.model.dto.SelectLessonDto;
import com.apa.university_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("")
    public ResponseEntity<Response> add(@RequestBody Student student) {
        Response result = this.studentService.add(student);
        if (result.getResultCode() == 200)
            return ResponseEntity.ok(result);
        return ResponseEntity.badRequest().body(result);
    }

    @PostMapping("/lessons")
    public ResponseEntity<Response> addLesson(@RequestBody SelectLessonDto selectLessonDto) {
        Response result = this.studentService.addLesson(selectLessonDto);
        if (result.getResultCode() == 200)
            return ResponseEntity.ok(result);
        return ResponseEntity.badRequest().body(result);
    }
}
