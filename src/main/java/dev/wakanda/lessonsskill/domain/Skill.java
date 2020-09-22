package dev.wakanda.lessonsskill.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	@Column(name = "tribe_id")
	private Long tribeId;

	@OneToMany(mappedBy = "skill")
	private List<Lesson> lessons;

	public Skill(String folderSkillName, LessonsSkillForms lessonsSkillDTO) {
		this.tribeId = lessonsSkillDTO.getTribeId();
		this.code = lessonsSkillDTO.getSkillCode();
		this.tribeSequence = lessonsSkillDTO.getTribeSequence();
		this.name = extractSkillNameByFolderSkillName(folderSkillName);
	}

	private String extractSkillNameByFolderSkillName(String folderSkillName) {
		return folderSkillName.replaceAll(REGEX_FOLDER_GDRIVE, "$2");
	}

	@Override
	public String toString() {
		return "Skill [code=" + code + ", name=" + name + ", tribeSequence=" + tribeSequence + "]";
	}
}
