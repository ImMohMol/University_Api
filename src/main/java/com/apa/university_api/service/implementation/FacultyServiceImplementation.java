package com.apa.university_api.service.implementation;

import com.apa.university_api.model.Faculty;
import com.apa.university_api.model.Response;
import com.apa.university_api.model.dto.faculty.FacultyDTO;
import com.apa.university_api.model.dto.mapper.Mapper;
import com.apa.university_api.repository.IFacultyRepository;
import com.apa.university_api.service.interfaces.IFacultyService;

import java.util.Optional;

public class FacultyServiceImplementation implements IFacultyService {
    private final IFacultyRepository facultyRepository;
    private final Mapper mapper;

    public FacultyServiceImplementation(IFacultyRepository facultyRepository, Mapper mapper) {
        this.facultyRepository = facultyRepository;
        this.mapper = mapper;
    }

    @Override
    public Response add(FacultyDTO facultyDTO) {
        try {
            // check if the faculty exists or not
            Optional<Faculty> isFacultyExists = this.facultyRepository.findByName(facultyDTO.getName());
            // just say that he/she can't insert this new faculty because it exists
            if (isFacultyExists.isPresent())
                return new Response(400, "This faculty exists can't add it again!", null);
            // insert the faculty and get the inserted faculty and return it in the response
            Faculty savedFaculty = this.mapper.convert(facultyDTO, Faculty.class);
            return new Response(200, "Faculty added successfully!", savedFaculty);
        } catch (Exception e) {
            // unknown error here
            return new Response(400, e.getMessage(), null);
        }
    }
}
