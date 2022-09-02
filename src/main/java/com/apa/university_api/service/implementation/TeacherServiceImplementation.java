package com.apa.university_api.service.implementation;

import com.apa.university_api.model.Response;
import com.apa.university_api.model.Teacher;
import com.apa.university_api.model.dto.mapper.Mapper;
import com.apa.university_api.model.dto.teacher.TeacherDTO;
import com.apa.university_api.repository.ITeacherRepository;
import com.apa.university_api.service.interfaces.ITeacherService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImplementation implements ITeacherService {
    private final ITeacherRepository teacherRepository;
    private final Mapper mapper;

    public TeacherServiceImplementation(ITeacherRepository teacherRepository, Mapper mapper) {
        this.teacherRepository = teacherRepository;
        this.mapper = mapper;
    }

    @Override
    public Response add(TeacherDTO teacherDTO) {
        Optional<Teacher> isTeacherExists = this.teacherRepository.findById(teacherDTO.getPersonalNumber());
        if (isTeacherExists.isPresent())
            return new Response(400, "This teacher exists can't add it again!", null);
        Teacher savedTeacher = this.mapper.convert(teacherDTO, Teacher.class);
        return new Response(200, "Teacher added successfully!", savedTeacher);
    }

    @Override
    public Response getStudents(String teacherPersonalNumber) {
        Optional<Teacher> teacher = this.teacherRepository.findById(teacherPersonalNumber);
        if (teacher.isEmpty())
            return new Response(400, "The teacher does not exists!", null);
        return new Response(200, "Success!", teacher.get().getStudents());
    }
}
