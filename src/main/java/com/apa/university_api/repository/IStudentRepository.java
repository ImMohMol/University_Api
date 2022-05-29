package com.apa.university_api.repository;

import com.apa.university_api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, String> {
}
