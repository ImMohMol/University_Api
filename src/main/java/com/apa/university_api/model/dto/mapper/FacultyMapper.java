package com.apa.university_api.model.dto.mapper;

import com.apa.university_api.model.Faculty;
import com.apa.university_api.model.dto.faculty.FacultyDTO;
import org.springframework.stereotype.Component;

@Component
public class FacultyMapper {
    public Faculty convertFacultyDtoToFaculty(FacultyDTO facultyDTO) {
        Faculty faculty = new Faculty();
        faculty.setName(facultyDTO.getName());
        return faculty;
    }
}
