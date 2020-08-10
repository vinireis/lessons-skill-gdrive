package dev.wakanda.lessonsskill.service;

import java.util.List;

import com.google.api.services.drive.model.File;

import dev.wakanda.lessonsskill.exception.GDriveException;

public interface DriveService {
	List<File> getFilesBySkillDriveId(String skillDriveID) throws GDriveException;
	String getFolderSkillName(String skillDriveID) throws GDriveException;
}
