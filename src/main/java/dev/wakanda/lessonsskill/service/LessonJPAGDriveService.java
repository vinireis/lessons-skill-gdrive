package dev.wakanda.lessonsskill.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.api.services.drive.model.File;

import dev.wakanda.lessonsskill.api.dto.LessonsSkillDTO;
import dev.wakanda.lessonsskill.domain.Lesson;
import dev.wakanda.lessonsskill.exception.GDriveException;
import dev.wakanda.lessonsskill.repository.LessonRepository;

@Service
public class LessonJPAGDriveService implements LessonService {
	private static final Logger log = LoggerFactory.getLogger(LessonJPAGDriveService.class);
	private LessonRepository lessonRepository;
	private DriveService driveService;

	public LessonJPAGDriveService(LessonRepository lessonRepository, DriveService driveService) {
		this.lessonRepository = lessonRepository;
		this.driveService = driveService;
	}

	@Override
	public void saveLessonsBySkill(LessonsSkillDTO lessonsSkill) throws GDriveException {
		log.info("Start Lesson Service");
		List<File> filesBySkillDriveId = driveService.getFilesBySkillDriveId(lessonsSkill.getSkillDriveID());
		List<Lesson> lessonsByGDriveFile = Lesson.convertToLessons(filesBySkillDriveId);
		logAllLessons(lessonsByGDriveFile);
	}

	@SuppressWarnings("unused")
	private void logAllLessons() {
		List<Lesson> findAll = lessonRepository.findAll();
		findAll.forEach(l -> log.info(l.toString()));
	}
	private void logAllLessons(List<Lesson> lessons) {
		lessons.forEach(l -> log.info(l.toString()));
	}
}
