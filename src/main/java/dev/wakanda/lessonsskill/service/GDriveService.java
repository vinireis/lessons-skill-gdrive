package dev.wakanda.lessonsskill.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;

import dev.wakanda.lessonsskill.exception.GDriveException;

@Service
public class GDriveService implements DriveService {
	private Drive driveService;

	public GDriveService(Drive driveService) {
		this.driveService = driveService;
	}

	@Override
	public List<File> getFilesBySkillDriveId(String skillDriveID) throws GDriveException {
		try {
			String query = "mimeType = 'application/vnd.google-apps.folder' and '"+skillDriveID+"' in parents";
			return driveService.files().list()
			.setQ(query)
			.setOrderBy("name")
			.execute().getFiles();
		} catch (IOException e) {
			throw new GDriveException(e);
		}
	}

	@Override
	public String getFolderSkillName(String skillDriveID) throws GDriveException {
		try {
			return driveService.files()
					.get(skillDriveID)
					.execute().getName();
		} catch (IOException e) {
			throw new GDriveException(e);
		}
	}

}
