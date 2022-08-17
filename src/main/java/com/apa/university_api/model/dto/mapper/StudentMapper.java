package com.apa.university_api.model.dto.mapper;

import com.apa.university_api.model.Student;
import com.apa.university_api.model.dto.student.StudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student convertStudentDtoToStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setStudentNumber(studentDTO.getStudentNumber());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setNationalCode(studentDTO.getNationalCode());
        return student;
    }
}
