package com.apa.university_api.repository;

import com.apa.university_api.model.Teacher;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITeacherRepository extends PagingAndSortingRepository<Teacher, String> {
}
