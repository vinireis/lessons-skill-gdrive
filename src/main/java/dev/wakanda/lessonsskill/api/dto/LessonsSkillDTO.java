package dev.wakanda.lessonsskill.api.dto;

public class LessonsSkillDTO {
	private String skillDriveID;
	private String skillCode;
	private String skillDifficulty;

	public LessonsSkillDTO(String skillDriveID, String skillCode, String skillDifficulty) {
		this.skillDriveID = skillDriveID;
		this.skillCode = skillCode;
		this.skillDifficulty = skillDifficulty;
	}

	public String getSkillDriveID() {
		return skillDriveID;
	}

	public String getSkillCode() {
		return skillCode;
	}

	public String getSkillDifficulty() {
		return skillDifficulty;
	}

	@Override
	public String toString() {
		return "LessonsSkillDTO [skillDriveID=" + skillDriveID + ", skillCode=" + skillCode + ", skillDifficulty="
				+ skillDifficulty + "]";
	}
	
	
}
