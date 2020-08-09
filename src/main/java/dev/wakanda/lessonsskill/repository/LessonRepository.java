package dev.wakanda.lessonsskill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wakanda.lessonsskill.domain.Lesson;

public interface LessonRepository extends JpaRepository<Lesson,Long> {

}
