package com.apa.university_api.controller;

import com.apa.university_api.model.Response;
import com.apa.university_api.model.dto.student.SelectLessonDto;
import com.apa.university_api.model.dto.student.StudentDTO;
import com.apa.university_api.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("")
    public ResponseEntity<Response> add(@RequestBody @Valid StudentDTO studentDTO) {
        Response result = this.studentService.add(studentDTO);
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
