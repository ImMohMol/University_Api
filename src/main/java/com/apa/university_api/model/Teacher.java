package com.apa.university_api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Teacher {
    @Id
    @Column(unique = true, nullable = false)
    private String personalNumber;
    @Column(unique = false, nullable = false)
    private String firstName;
    @Column(unique = false, nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false, length = 10)
    private String nationalCode;
    @OneToMany
    private List<Lesson> lessons;
    @OneToMany
    private List<Student> students;

    public Teacher() {
    }

    public Teacher(String personalNumber, String firstName, String lastName, String nationalCode, List<Lesson> lessons, List<Student> students) {
        this.personalNumber = personalNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.lessons = lessons;
        this.students = students;
    }

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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
