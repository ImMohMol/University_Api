package com.apa.university_api.service.interfaces;

import com.apa.university_api.model.Response;
import com.apa.university_api.model.dto.faculty.FacultyDTO;

public interface IFacultyService {
    Response add(FacultyDTO facultyDTO);
}
