package dev.wakanda.lessonsskill.service;

import dev.wakanda.lessonsskill.api.dto.LessonsSkillForms;
import dev.wakanda.lessonsskill.exception.GDriveException;

public interface LessonService {
	public void saveLessonsBySkill(LessonsSkillForms lessonsSkill) throws GDriveException;
}
