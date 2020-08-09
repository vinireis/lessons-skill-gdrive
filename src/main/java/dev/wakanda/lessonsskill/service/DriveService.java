package dev.wakanda.lessonsskill.service;

import java.util.List;

public interface DriveService {

	List<LessonGDriveFile> getFilesBySkillDriveId(String skillDriveID);

}
