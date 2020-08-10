package dev.wakanda.lessonsskill.api.dto;

import dev.wakanda.lessonsskill.domain.Skill;
import dev.wakanda.lessonsskill.exception.GDriveException;
import dev.wakanda.lessonsskill.service.DriveService;

public class LessonsSkillDTO {
	private String skillDriveID;
	private String skillCode;
	private String skillDifficulty;
	private Long tribeId;
	private Integer tribeSequence;

	public LessonsSkillDTO(String skillDriveID, String skillCode, String skillDifficulty, Long tribeId,
			Integer tribeSequence) {
		this.skillDriveID = skillDriveID;
		this.skillCode = skillCode;
		this.skillDifficulty = skillDifficulty;
		this.tribeId = tribeId;
		this.tribeSequence = tribeSequence;
	}

	public String getSkillDriveID() {
		return skillDriveID;
	}

	public Long getTribeId() {
		return tribeId;
	}

	public String getSkillCode() {
		return skillCode;
	}

	public String getSkillDifficulty() {
		return skillDifficulty;
	}

	public Integer getTribeSequence() {
		return tribeSequence;
	}

	@Override
	public String toString() {
		return "LessonsSkillDTO [skillDriveID=" + skillDriveID + ", skillCode=" + skillCode + ", skillDifficulty="
				+ skillDifficulty + ", tribeId=" + tribeId + ", tribeSequence=" + tribeSequence + "]";
	}

	public Skill convertToSkill(DriveService driveService) throws GDriveException {
		String folderSkillName = driveService.getFolderSkillName(this.getSkillDriveID());
		return new Skill(folderSkillName, this);
	}
}
