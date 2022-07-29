package com.apa.university_api.repository;

import com.apa.university_api.model.Faculty;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFacultyRepository extends PagingAndSortingRepository<Faculty, Long> {
    Optional<Faculty> findByName(String facultyName);
}
