package com.apa.university_api.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany
    private List<Teacher> teachers;
    @OneToMany
    private List<Student> students;
    @OneToMany
    private List<Lesson> lessons;

    public Faculty() {
    }

    public Faculty(String name, List<Teacher> teachers, List<Student> students, List<Lesson> lessons) {
        this.name = name;
        this.teachers = teachers;
        this.students = students;
        this.lessons = lessons;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
