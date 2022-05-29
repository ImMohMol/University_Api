package com.apa.university_api.model;

import java.util.List;

public class Faculty {
    private String name;
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Lesson> lessons;

    public Faculty() {
    }

    public Faculty(String name, List<Teacher> teachers, List<Student> students, List<Lesson> lessons) {
        this.name = name;
        this.teachers = teachers;
        this.students = students;
        this.lessons = lessons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
