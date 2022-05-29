package com.apa.university_api.controller;

import com.apa.university_api.model.Faculty;
import com.apa.university_api.model.Response;
import com.apa.university_api.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/faculty")
public class FacultyController {
    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Response> add(@RequestBody Faculty faculty) {
        Response result = this.facultyService.add(faculty);
        if (result.getResultCode() == 200)
            return ResponseEntity.ok(result);
        return ResponseEntity.badRequest().body(result);
    }
}
