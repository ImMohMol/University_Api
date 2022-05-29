package com.apa.university_api.service;

import com.apa.university_api.model.Faculty;
import com.apa.university_api.model.Response;
import com.apa.university_api.repository.IFacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacultyService {
    private final IFacultyRepository facultyRepository;

    @Autowired
    public FacultyService(IFacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Response add(Faculty faculty) {
        try {
            boolean isFacultyExists = this.facultyRepository.existsById(faculty.getId());
            if (isFacultyExists)
                return new Response(400, "This faculty exists can't add it again!", null);
            Faculty savedFaculty = this.facultyRepository.save(faculty);
            return new Response(200, "Faculty added successfully!", savedFaculty);
        } catch (Exception e) {
            return new Response(400, e.getMessage(), null);
        }
    }
}
