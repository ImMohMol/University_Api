package com.apa.university_api.service.interfaces;

import com.apa.university_api.model.Response;
import com.apa.university_api.model.dto.teacher.TeacherDTO;

public interface ITeacherService {
    Response add(TeacherDTO teacherDTO);

    Response getStudents(String teacherPersonalNumber);
}
