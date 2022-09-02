package com.apa.university_api.service.interfaces;

import com.apa.university_api.model.Response;
import com.apa.university_api.model.dto.student.EnrollLessonDTO;
import com.apa.university_api.model.dto.student.StudentDTO;

public interface IStudentService {
    Response add(StudentDTO studentDTO);

    Response enrollLesson(EnrollLessonDTO enrollLessonDTO);
}
