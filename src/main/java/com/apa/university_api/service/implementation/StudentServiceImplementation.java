package com.apa.university_api.service.implementation;

import com.apa.university_api.model.Lesson;
import com.apa.university_api.model.Response;
import com.apa.university_api.model.Student;
import com.apa.university_api.model.dto.mapper.Mapper;
import com.apa.university_api.model.dto.student.EnrollLessonDTO;
import com.apa.university_api.model.dto.student.StudentDTO;
import com.apa.university_api.repository.IStudentRepository;
import com.apa.university_api.service.interfaces.IStudentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImplementation implements IStudentService {
    private final IStudentRepository studentRepository;
    private final Mapper mapper;

    public StudentServiceImplementation(IStudentRepository studentRepository, Mapper mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    @Override
    public Response add(StudentDTO studentDTO) {
        Optional<Student> isStudentExists = this.studentRepository.findById(studentDTO.getStudentNumber());
        if (isStudentExists.isPresent())
            return new Response(400, "This student exists can't add it again!", null);
        Student student = this.mapper.convert(studentDTO, Student.class);
        Student savedStudent = this.studentRepository.save(student);
        return new Response(200, "Student added successfully!", savedStudent);
    }

    @Override
    public Response enrollLesson(EnrollLessonDTO enrollLessonDTO) {
        Optional<Student> student = this.studentRepository.findById(enrollLessonDTO.getStudentNumber());
        Lesson lesson = this.lessonService.get(enrollLessonDTO.getLessonId());
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
