package com.apa.university_api.repository;

import com.apa.university_api.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacultyRepository extends JpaRepository<Faculty, Long> {
}