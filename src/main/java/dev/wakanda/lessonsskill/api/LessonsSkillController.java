package dev.wakanda.lessonsskill.api;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.wakanda.lessonsskill.api.dto.LessonsSkillForms;
import dev.wakanda.lessonsskill.exception.GDriveException;
import dev.wakanda.lessonsskill.service.LessonService;

@RestController
@RequestMapping(path = "/skill")
public class LessonsSkillController {
	private static final Logger log = LoggerFactory.getLogger(LessonsSkillController.class);
	private LessonService lessonService;

	public LessonsSkillController(LessonService lessonService) {
		this.lessonService = lessonService;
	}

	@PostMapping(path = "/lesson")
	public void saveLessonsBySkill(@Valid LessonsSkillForms lessonsSkillForms) throws GDriveException {
		log.info("Start Controller!");
		log.info("Request Body: {}", lessonsSkillForms);
		lessonService.saveLessonsBySkill(lessonsSkillForms);
	}
}
