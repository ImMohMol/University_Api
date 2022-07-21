package com.apa.university_api.repository;

import com.apa.university_api.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IStudentRepository extends PagingAndSortingRepository<Student, String> {
}
