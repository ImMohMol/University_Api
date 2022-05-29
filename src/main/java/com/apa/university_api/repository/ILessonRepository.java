package com.apa.university_api.repository;

import com.apa.university_api.model.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILessonRepository extends JpaRepository<Lesson, Long> {
}
