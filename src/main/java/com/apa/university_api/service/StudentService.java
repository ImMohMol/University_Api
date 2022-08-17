package com.apa.university_api.service;

import com.apa.university_api.model.Lesson;
import com.apa.university_api.model.Response;
import com.apa.university_api.model.Student;
import com.apa.university_api.model.dto.student.SelectLessonDto;
import com.apa.university_api.model.dto.mapper.StudentMapper;
import com.apa.university_api.model.dto.student.StudentDTO;
import com.apa.university_api.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    private final IStudentRepository studentRepository;
    private final LessonService lessonService;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(IStudentRepository studentRepository, LessonService lessonService, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.lessonService = lessonService;
        this.studentMapper = studentMapper;
    }

    public Response add(StudentDTO studentDTO) {
        Optional<Student> isStudentExists = this.studentRepository.findById(studentDTO.getStudentNumber());
        if (isStudentExists.isPresent())
            return new Response(400, "This student exists can't add it again!", null);
        Student student = this.studentMapper.convertStudentDtoToStudent(studentDTO);
        Student savedStudent = this.studentRepository.save(student);
        return new Response(200, "Student added successfully!", savedStudent);
    }

    public Response addLesson(SelectLessonDto selectLessonDto) {
        Optional<Student> student = this.studentRepository.findById(selectLessonDto.getStudentNumber());
        Lesson lesson = this.lessonService.get(selectLessonDto.getLessonId());
        if (student.isEmpty())
            return new Response(400, "This student doesn't exists!", null);
        if (lesson == null)
            return new Response(400, "This lesson doesn't exists!", null);
        if (student.get().getLessons().contains(lesson))
            return new Response(400, "This lesson picked already! Can't pick it again!", null);
        student.get().getLessons().add(lesson);
        studentRepository.save(student.get());
        return new Response(200, "Lesson added successfully!", lesson);
    }
}
