package com.apa.university_api.model.dto;

import com.apa.university_api.model.Student;

import java.util.List;

public class LessonDto {
    private String name;
    private Integer grade;
    private String teacherPersonalNumber;
    private List<Student> students;

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

    public String getTeacherPersonalNumber() {
        return teacherPersonalNumber;
    }

    public void setTeacherPersonalNumber(String teacherPersonalNumber) {
        this.teacherPersonalNumber = teacherPersonalNumber;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
