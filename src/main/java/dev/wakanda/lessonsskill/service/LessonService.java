package dev.wakanda.lessonsskill.service;

import dev.wakanda.lessonsskill.api.dto.LessonsSkillDTO;
import dev.wakanda.lessonsskill.exception.GDriveException;

public interface LessonService {
	public void saveLessonsBySkill(LessonsSkillDTO lessonsSkill) throws GDriveException;
}
