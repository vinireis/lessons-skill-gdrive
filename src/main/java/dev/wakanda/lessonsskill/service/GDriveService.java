package dev.wakanda.lessonsskill.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GDriveService implements DriveService {
	@Override
	public List<LessonGDriveFile> getFilesBySkillDriveId(String skillDriveID) {
		List<LessonGDriveFile> filesByGDrive = new ArrayList<>();
		filesByGDrive.add(new LessonGDriveFile());
		return filesByGDrive;
	}

}
