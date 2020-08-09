package dev.wakanda.lessonsskill.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.wakanda.lessonsskill.api.dto.LessonsSkillDTO;

@RestController
@RequestMapping(path = "/skill")
public class LessonsSkillController {
	private static final Logger log = LoggerFactory.getLogger(LessonsSkillController.class);
//	private LessonJPAGDriveService lessonService;

	@PostMapping(path = "/lesson")
	public void saveLessonsBySkill(LessonsSkillDTO lessonsSkillDTO) {
		log.info("Start Controller!");
		log.info("Request Body: {}",lessonsSkillDTO);
//		lessonService.saveLessonsBySkill(lessonsSkillDTO);
	}
}