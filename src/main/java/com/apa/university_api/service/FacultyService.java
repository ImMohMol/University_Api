package com.apa.university_api.service;

import com.apa.university_api.model.Faculty;
import com.apa.university_api.model.Response;
import com.apa.university_api.repository.IFacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
    private final IFacultyRepository facultyRepository;

    @Autowired
    public FacultyService(IFacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Response add(Faculty faculty) {
        try {
            // check if the faculty exists or not
            boolean isFacultyExists = this.facultyRepository.existsById(faculty.getId());
            // just say that he/she can't insert this new faculty because it exists
            if (isFacultyExists)
                return new Response(400, "This faculty exists can't add it again!", null);
            // insert the faculty and get the inserted faculty and return it in the response
            Faculty savedFaculty = this.facultyRepository.save(faculty);
            return new Response(200, "Faculty added successfully!", savedFaculty);
        } catch (Exception e) {
            // unknown error here
            return new Response(400, e.getMessage(), null);
        }
    }
}
