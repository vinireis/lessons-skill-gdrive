package dev.wakanda.lessonsskill.domain;

import java.util.List;
import java.util.Optional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import dev.wakanda.lessonsskill.api.dto.LessonsSkillForms;

@Entity
@Table(name = "skills")
public class Skill {
	private static final String REGEX_FOLDER_GDRIVE = "(^\\d{1,2}) (.*)";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 60, unique = true)
	private String code;

	@Column(nullable = false, length = 120)
	private String name;

	@Lob
	private String description;

	private Integer tribeSequence;
	@Transient
	private Integer skillDifficult;

	@Column(name = "tribe_id")
	private Long tribeId;

	@OneToMany(mappedBy = "skill")
	private List<Lesson> lessons;

	public Skill(String folderSkillName, LessonsSkillForms lessonsSkillDTO) {
		this.tribeId = lessonsSkillDTO.getTribeId();
		this.code = lessonsSkillDTO.getSkillCode();
		this.tribeSequence = lessonsSkillDTO.getTribeSequence();
		this.skillDifficult = lessonsSkillDTO.getSkillDifficulty();
		this.name = extractSkillNameByFolderSkillName(folderSkillName).orElse(folderSkillName);
	}

	private Optional<String> extractSkillNameByFolderSkillName(String folderSkillName) {
		try {
			return Optional.of(folderSkillName.replaceAll(REGEX_FOLDER_GDRIVE, "$2"));
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	@Override
	public String toString() {
		return "Skill [code=" + getCode() + ", name=" + name + ", tribeSequence=" + tribeSequence + ", skillDifficult="
				+ getSkillDifficult() + "]";
	}

	@Transient
	public Integer getSkillDifficult() {
		return skillDifficult;
	}

	public String getCode() {
		return code;
	}
}
