package com.apa.university_api.model.dto.faculty;

import javax.validation.constraints.NotNull;

public class FacultyDTO {
    @NotNull(message = "name field value can not be null")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
