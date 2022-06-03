package com.apa.university_api.repository;

import com.apa.university_api.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ILessonRepository extends JpaRepository<Lesson, Long> {
    Optional<Lesson> findByName(String name);
}
