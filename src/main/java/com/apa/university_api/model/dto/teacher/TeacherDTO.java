package com.apa.university_api.model.dto.teacher;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeacherDTO {
    @NotNull(message = "The value of parameter personalNumber can not be null")
    private String personalNumber;
    @NotNull(message = "The value of parameter firstName can not be null")
    private String firstName;
    @NotNull(message = "The value of parameter lastName can not be null")
    private String lastName;
    @NotNull(message = "The value of parameter nationalCode can not be null")
    @Size(min = 10, max = 10, message = "The nationalCode must be 10 digits")
    private String nationalCode;

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }
}
