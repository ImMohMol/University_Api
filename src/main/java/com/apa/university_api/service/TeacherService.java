package com.apa.university_api.service;

import com.apa.university_api.model.Response;
import com.apa.university_api.model.Teacher;
import com.apa.university_api.model.dto.mapper.Mapper;
import com.apa.university_api.model.dto.mapper.TeacherMapper;
import com.apa.university_api.model.dto.teacher.TeacherDTO;
import com.apa.university_api.repository.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherService {
    private final ITeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;
    private final Mapper mapper;

    @Autowired
    public TeacherService(ITeacherRepository teacherRepository, TeacherMapper teacherMapper, Mapper mapper) {
        this.teacherRepository = teacherRepository;
        this.teacherMapper = teacherMapper;
        this.mapper = mapper;
    }

    public Response add(TeacherDTO teacherDto) {
        Optional<Teacher> isTeacherExists = this.teacherRepository.findById(teacherDto.getPersonalNumber());
        if (isTeacherExists.isPresent())
            return new Response(400, "This teacher exists can't add it again!", null);
        Teacher teacher = this.teacherMapper.convertTeacherDtoToTeacher(teacherDto);
        Teacher savedTeacher = this.mapper.convert(teacherDto, Teacher.class);
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
