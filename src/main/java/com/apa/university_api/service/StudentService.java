package com.apa.university_api.service;

import com.apa.university_api.model.dto.mapper.Mapper;
import com.apa.university_api.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final IStudentRepository studentRepository;
    private final LessonService lessonService;
    private final Mapper mapper;

    @Autowired
    public StudentService(IStudentRepository studentRepository, LessonService lessonService, Mapper mapper) {
        this.studentRepository = studentRepository;
        this.lessonService = lessonService;
        this.mapper = mapper;
    }

//    public Response add(StudentDTO studentDTO) {
//        Optional<Student> isStudentExists = this.studentRepository.findById(studentDTO.getStudentNumber());
//        if (isStudentExists.isPresent())
//            return new Response(400, "This student exists can't add it again!", null);
//        Student student = this.mapper.convert(studentDTO, Student.class);
//        Student savedStudent = this.studentRepository.save(student);
//        return new Response(200, "Student added successfully!", savedStudent);
//    }

//    public Response addLesson(EnrollLessonDTO enrollLessonDto) {
//        Optional<Student> student = this.studentRepository.findById(enrollLessonDto.getStudentNumber());
//        Lesson lesson = this.lessonService.get(enrollLessonDto.getLessonId());
//        if (student.isEmpty())
//            return new Response(400, "This student doesn't exists!", null);
//        if (lesson == null)
//            return new Response(400, "This lesson doesn't exists!", null);
//        if (student.get().getLessons().contains(lesson))
//            return new Response(400, "This lesson picked already! Can't pick it again!", null);
//        student.get().getLessons().add(lesson);
//        studentRepository.save(student.get());
//        return new Response(200, "Lesson added successfully!", lesson);
//    }
}
