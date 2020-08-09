package dev.wakanda.lessonsskill.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakanda.lessonsskill.api.dto.LessonsSkillDTO;
import dev.wakanda.lessonsskill.domain.Lesson;
import dev.wakanda.lessonsskill.repository.LessonRepository;

@Service
public class LessonJPAGDriveService implements LessonService {
	private static final Logger log = LoggerFactory.getLogger(LessonJPAGDriveService.class);
	private LessonRepository lessonRepository;

	public LessonJPAGDriveService(LessonRepository lessonRepository) {
		this.lessonRepository = lessonRepository;
	}

	@Override
	public void saveLessonsBySkill(LessonsSkillDTO lessonsSkill) {
		log.info("Start Service");
//		logAllLessons();
	}

	@SuppressWarnings("unused")
	private void logAllLessons() {
		List<Lesson> findAll = lessonRepository.findAll();
		findAll.forEach(l -> log.info(l.toString()));
	}
}
