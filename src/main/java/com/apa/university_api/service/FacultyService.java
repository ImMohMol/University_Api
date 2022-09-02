package com.apa.university_api.service;

import com.apa.university_api.model.dto.mapper.FacultyMapper;
import com.apa.university_api.model.dto.mapper.Mapper;
import com.apa.university_api.repository.IFacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
    private final IFacultyRepository facultyRepository;
    private final FacultyMapper facultyMapper;
    private final Mapper mapper;

    @Autowired
    public FacultyService(IFacultyRepository facultyRepository, FacultyMapper facultyMapper, Mapper mapper) {
        this.facultyRepository = facultyRepository;
        this.facultyMapper = facultyMapper;
        this.mapper = mapper;
    }

//    public Response add(FacultyDTO facultyDTO) {
//        try {
//            // check if the faculty exists or not
//            Optional<Faculty> isFacultyExists = this.facultyRepository.findByName(facultyDTO.getName());
//            // just say that he/she can't insert this new faculty because it exists
//            if (isFacultyExists.isPresent())
//                return new Response(400, "This faculty exists can't add it again!", null);
//            // map dto to model
//            Faculty faculty = this.facultyMapper.convertFacultyDtoToFaculty(facultyDTO);
//            // insert the faculty and get the inserted faculty and return it in the response
//            Faculty savedFaculty = this.mapper.convert(facultyDTO, Faculty.class);
//            return new Response(200, "Faculty added successfully!", savedFaculty);
//        } catch (Exception e) {
//            // unknown error here
//            return new Response(400, e.getMessage(), null);
//        }
//    }
}
