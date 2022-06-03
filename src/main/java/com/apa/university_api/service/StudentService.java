package com.apa.university_api.service;

import com.apa.university_api.model.Response;
import com.apa.university_api.model.Student;
import com.apa.university_api.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Response add(Student student) {
        Optional<Student> isStudentExists = this.studentRepository.findById(student.getStudentNumber());
        if (isStudentExists.isPresent())
            return new Response(400, "This student exists can't add it again!", null);
        Student savedStudent = this.studentRepository.save(student);
        return new Response(200, "Student added successfully!", savedStudent);
    }
}
