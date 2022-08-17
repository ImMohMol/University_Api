package com.apa.university_api.service;

import com.apa.university_api.model.Lesson;
import com.apa.university_api.model.Response;
import com.apa.university_api.model.dto.lesson.LessonDTO;
import com.apa.university_api.model.dto.mapper.LessonMapper;
import com.apa.university_api.repository.ILessonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class LessonServiceTest {
    private final ILessonRepository lessonRepository = Mockito.mock(ILessonRepository.class);
    private final LessonMapper lessonMapper = Mockito.mock(LessonMapper.class);
    private final LessonService lessonService = new LessonService(this.lessonRepository, this.lessonMapper);

    @Test
    void addLessonUnitTest() {
        when(this.lessonRepository.findByName(anyString())).thenReturn(Optional.empty());
        when(this.lessonMapper.convertLessonDtoToLesson(any())).thenReturn(getLesson());
        Response result = this.lessonService.add(getLessonDTO(getLesson()));
        assertThat(result.getResultCode()).isEqualTo(200);
    }

    private Lesson getLesson() {
        Lesson lesson = new Lesson();
        lesson.setName("Software Engineering");
        lesson.setGrade(3);
        return lesson;
    }

    private LessonDTO getLessonDTO(Lesson lesson) {
        LessonDTO lessonDTO = new LessonDTO();
        lessonDTO.setName(lesson.getName());
        lessonDTO.setGrade(lesson.getGrade());
        return lessonDTO;
    }
}