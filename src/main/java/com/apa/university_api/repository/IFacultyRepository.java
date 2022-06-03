package com.apa.university_api.repository;

import com.apa.university_api.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFacultyRepository extends JpaRepository<Faculty, Long> {
    Optional<Faculty> findByName(String facultyName);
}
