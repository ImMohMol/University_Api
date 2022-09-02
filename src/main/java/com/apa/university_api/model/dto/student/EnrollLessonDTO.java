package com.apa.university_api.model.dto.student;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EnrollLessonDTO {
    @NotNull(message = "The value of parameter studentNumber can not be null")
    @Size(min = 7, max = 7, message = "StudentNumber must be 7 digits")
    private String studentNumber;
    @NotNull(message = "The value of parameter lessonId can not be null")
    @Min(value = 1, message = "The value of parameter lessonId must be greater than 0")
    private Long lessonId;

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Long getLessonId() {
        return lessonId;
    }

    public void setLessonId(Long lessonId) {
        this.lessonId = lessonId;
    }
}
