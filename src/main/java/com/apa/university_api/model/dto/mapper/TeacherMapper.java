package com.apa.university_api.model.dto.mapper;

import com.apa.university_api.model.Teacher;
import com.apa.university_api.model.dto.teacher.TeacherDTO;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {
    public Teacher convertTeacherDtoToTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setPersonalNumber(teacherDTO.getPersonalNumber());
        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setLastName(teacherDTO.getLastName());
        teacher.setNationalCode(teacherDTO.getNationalCode());
        return teacher;
    }
}
