package dev.wakanda.lessonsskill.api.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import dev.wakanda.lessonsskill.domain.Skill;
import dev.wakanda.lessonsskill.exception.GDriveException;
import dev.wakanda.lessonsskill.service.DriveService;

@Valid
public class LessonsSkillForms {
	@NotBlank
	private String skillDriveID;
	@NotBlank
	private String skillCode;
	@NotBlank
	private Integer skillDifficulty;
	@NotNull
	private Long tribeId;
	@NotNull
	private Integer tribeSequence;

	public LessonsSkillForms(String skillDriveID, String skillCode, Integer skillDifficulty, Long tribeId,
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

	public Integer getSkillDifficulty() {
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
