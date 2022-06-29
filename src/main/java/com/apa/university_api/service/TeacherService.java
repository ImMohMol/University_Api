package com.apa.university_api.service;

import com.apa.university_api.model.Response;
import com.apa.university_api.model.Teacher;
import com.apa.university_api.repository.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {
    private final ITeacherRepository teacherRepository;

    @Autowired
    public TeacherService(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Response add(Teacher teacher) {
        Optional<Teacher> isTeacherExists = this.teacherRepository.findById(teacher.getPersonalNumber());
        if (isTeacherExists.isPresent())
            return new Response(400, "This teacher exists can't add it again!", null);
        Teacher savedTeacher = this.teacherRepository.save(teacher);
        return new Response(200, "Teacher added successfully!", savedTeacher);
    }

    public Teacher get(String personalNumber) {
        Optional<Teacher> teacher = this.teacherRepository.findById(personalNumber);
        return teacher.orElse(null);
    }

    public Response getStudents(String teacherPersonalNumber) {
        Optional<Teacher> teacher = this.teacherRepository.findById(teacherPersonalNumber);
        if (teacher.isEmpty())
            return new Response(400, "The teacher does not exists!", null);
        return new Response(200, "Success!", teacher.get().getStudents());
    }
}
