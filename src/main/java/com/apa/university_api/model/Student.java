package com.apa.university_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @Column(unique = true, nullable = false, length = 7)
    private String studentNumber;
    @Column(unique = false, nullable = false)
    private String firstName;
    @Column(unique = false, nullable = false)
    private String lastName;
    @Column(unique = true, nullable = false, length = 10)
    private String nationalCode;
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "student_lessons", joinColumns = @JoinColumn(name = "lesson_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Lesson> lessons;

    public Student() {
    }

    public Student(String studentNumber, String firstName, String lastName, String nationalCode, List<Lesson> lessons) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.lessons = lessons;
    }

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

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
