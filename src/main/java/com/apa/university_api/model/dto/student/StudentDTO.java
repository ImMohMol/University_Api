package com.apa.university_api.model.dto.student;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class StudentDTO {
    @NotNull(message = "The value of parameter studentNumber can not be null")
    @Size(min = 7, max = 7, message = "StudentNumber must be 7 digits")
    private String studentNumber;
    @NotNull(message = "The value of parameter firstName can not be null")
    private String firstName;
    @NotNull(message = "The value of parameter lastName can not be null")
    private String lastName;
    @NotNull(message = "The value of parameter nationalCode can not be null")
    @Size(min = 10, max = 10, message = "NationalCode must be 10 digits")
    private String nationalCode;

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
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
