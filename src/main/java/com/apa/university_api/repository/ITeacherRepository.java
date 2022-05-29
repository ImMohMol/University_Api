package com.apa.university_api.repository;

import com.apa.university_api.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeacherRepository extends JpaRepository<Teacher, String> {
}
