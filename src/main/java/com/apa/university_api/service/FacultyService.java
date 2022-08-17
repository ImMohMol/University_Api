package com.apa.university_api.service;

import com.apa.university_api.model.Faculty;
import com.apa.university_api.model.Response;
import com.apa.university_api.model.dto.faculty.FacultyDTO;
import com.apa.university_api.model.dto.mapper.FacultyMapper;
import com.apa.university_api.repository.IFacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacultyService {
    private final IFacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;

    @Autowired
    public FacultyService(IFacultyRepository facultyRepository, FacultyMapper facultyMapper) {
        this.facultyRepository = facultyRepository;
        this.facultyMapper = facultyMapper;
    }

    public Response add(FacultyDTO facultyDTO) {
        try {
            // check if the faculty exists or not
            Optional<Faculty> isFacultyExists = this.facultyRepository.findByName(facultyDTO.getName());
            // just say that he/she can't insert this new faculty because it exists
            if (isFacultyExists.isPresent())
                return new Response(400, "This faculty exists can't add it again!", null);
            // map dto to model
            Faculty faculty = this.facultyMapper.convertFacultyDtoToFaculty(facultyDTO);
            // insert the faculty and get the inserted faculty and return it in the response
            Faculty savedFaculty = this.facultyRepository.save(faculty);
            return new Response(200, "Faculty added successfully!", savedFaculty);
        } catch (Exception e) {
            // unknown error here
            return new Response(400, e.getMessage(), null);
        }
    }
}
