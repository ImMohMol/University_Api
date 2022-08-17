package com.apa.university_api.model.dto.lesson;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class LessonDTO {
    @NotNull(message = "The lesson name can not be null")
    private String name;
    @NotNull(message = "The grade value can not be null")
    @Min(value = 1, message = "The value of grade should be greater than 0")
    @Max(value = 4, message = "The value of grade should be lower or equal than 4")
    private Integer grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
