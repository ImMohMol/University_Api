package com.apa.university_api.service;

import com.apa.university_api.model.Faculty;
import com.apa.university_api.model.dto.faculty.FacultyDTO;
import com.apa.university_api.model.dto.mapper.FacultyMapper;
import com.apa.university_api.repository.IFacultyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class FacultyServiceTest {
    private final IFacultyRepository facultyRepository = Mockito.mock(IFacultyRepository.class);
    private final FacultyMapper facultyMapper = Mockito.mock(FacultyMapper.class);
//    private final FacultyService facultyService = new FacultyService(this.facultyRepository, this.facultyMapper, mapper);

    @Test
    void addFacultyUnitTest() {
        when(this.facultyRepository.findByName(anyString())).thenReturn(Optional.empty());
        when(this.facultyMapper.convertFacultyDtoToFaculty(any())).thenReturn(getFaculty());
//        Response result = this.facultyService.add(getFacultyDTO(getFaculty()));
//        assertThat(result.getResultCode()).isEqualTo(200);
    }

    private Faculty getFaculty() {
        Faculty handler = new Faculty();
        handler.setName("Computer");
        return handler;
    }

    private FacultyDTO getFacultyDTO(Faculty faculty) {
        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setName(faculty.getName());
        return facultyDTO;
    }
}