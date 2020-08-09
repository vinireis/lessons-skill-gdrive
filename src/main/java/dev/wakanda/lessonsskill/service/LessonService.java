package dev.wakanda.lessonsskill.service;

import dev.wakanda.lessonsskill.api.dto.LessonsSkillDTO;

public interface LessonService {
	public void saveLessonsBySkill(LessonsSkillDTO lessonsSkill);
}
