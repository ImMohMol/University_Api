package com.apa.university_api.service;

import com.apa.university_api.model.Response;
import com.apa.university_api.model.Student;
import com.apa.university_api.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;
    private Student student;

    @BeforeEach
    private void setup() {
        this.student = new Student("4567896",
                "Mohammad Hossein",
                "Molaeian",
                "0213622259",
                new ArrayList<>());
    }

    @Test
    void shouldAddStudent() {
        Response saveStudentResult = studentService.add(this.student);
        assertThat(saveStudentResult.getResultCode()).isEqualTo(200);
        assertThat(saveStudentResult.getResultMessage()).isEqualTo("Student added successfully!");
    }

    @Test
    void shouldAddLessonToAStudentLessons() {

    }
}