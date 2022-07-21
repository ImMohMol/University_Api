package com.apa.university_api.repository;

import com.apa.university_api.model.Lesson;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ILessonRepository extends PagingAndSortingRepository<Lesson, Long> {
    Optional<Lesson> findByName(String name);
}
