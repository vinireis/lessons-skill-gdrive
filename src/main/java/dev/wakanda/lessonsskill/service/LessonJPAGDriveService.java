package dev.wakanda.lessonsskill.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import dev.wakanda.lessonsskill.api.dto.LessonsSkillDTO;

@Service
public class LessonJPAGDriveService implements LessonService {
	private static final Logger log = LoggerFactory.getLogger(LessonJPAGDriveService.class);
	@Override
	public void saveLessonsBySkill(LessonsSkillDTO lessonsSkill) {
		log.info("Start Service");
	}

}
