package com.apa.university_api.service;

import com.apa.university_api.model.Faculty;
import com.apa.university_api.model.Response;
import com.apa.university_api.repository.IFacultyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class FacultyServiceTest {

    @Mock
    private IFacultyRepository facultyRepository;
    @InjectMocks
    private FacultyService facultyService;
    private Faculty faculty;

    @BeforeEach
    public void setup() {
        this.faculty = new Faculty();
        faculty.setId(5L);
        faculty.setName("Mechanic");
        faculty.setStudents(null);
        faculty.setTeachers(null);
        faculty.setLessons(null);
    }

    @Test
    void add() {
        given(this.facultyRepository.findByName(this.faculty.getName())).willReturn(Optional.of(new Faculty()));
        Response result = this.facultyService.add(this.faculty);
        assertThat(result.getResultCode()).isEqualTo(200);
        assertThat(result.getResultMessage()).isEqualTo("Faculty added successfully!");
    }
}