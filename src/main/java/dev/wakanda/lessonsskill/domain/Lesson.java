package dev.wakanda.lessonsskill.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.google.api.services.drive.model.File;

@Entity
@Table(name = "lessons")
public class Lesson {
	private static final String REGEX_FOLDER_LESSON_GDRIVE = "(^\\d{1,2}) (.*)";
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 60, unique = true)
	private String code;
	@Column(length = 120, nullable = false)
	private String name;
	@Column(name = "file_id")
	private String fileId;
	private Float difficulty;
	private Integer skillSequence;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "skill_id", referencedColumnName = "id")
	private Skill skill;

	public Lesson(File gDriveFile) {
		this.name = extractLessonNameByFolderLessonName(gDriveFile.getName()).orElse(gDriveFile.getName());
		this.skillSequence = extractLessonSequenceByFolderLessonName(gDriveFile.getName()).orElse(0);
		this.fileId = gDriveFile.getId();
	}

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public Float getDifficulty() {
		return difficulty;
	}

	public Lesson setDifficulty(Float difficulty) {
		this.difficulty = difficulty;
		return this;
	}

	public String getFileId() {
		return fileId;
	}

	public Integer getSkillSequence() {
		return skillSequence;
	}
	
	public Skill getSkill() {
		return skill;
	}

	public Lesson setSkill(Skill skill) {
		this.skill = skill;
		return this;
	}

	private Optional<Integer> extractLessonSequenceByFolderLessonName(String folderLessonName) {
		try {
			return Optional.of(Integer.parseInt(folderLessonName.replaceAll(REGEX_FOLDER_LESSON_GDRIVE, "$1")));
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	private Optional<String> extractLessonNameByFolderLessonName(String folderLessonName) {
		try {
			return Optional.of(folderLessonName.replaceAll(REGEX_FOLDER_LESSON_GDRIVE, "$2"));
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((skillSequence == null) ? 0 : skillSequence.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (skillSequence == null) {
			if (other.skillSequence != null)
				return false;
		} else if (!skillSequence.equals(other.skillSequence))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lesson [code=" + code + ", name=" + name + ", fileId=" + fileId + ", difficulty=" + difficulty
				+ ", skillSequence=" + skillSequence + ", skill=" + skill + "]";
	}

	public static List<Lesson> convertToLessons(List<File> filesBySkillDriveId,Skill skill) {
		return filesBySkillDriveId.parallelStream()
				.map(Lesson::new)
				.map(l -> l.setSkill(skill))
				.map(l -> l.setDifficulty(getLessonDifficulty(filesBySkillDriveId, skill)))
				.collect(Collectors.toList());
	}

	private static float getLessonDifficulty(List<File> filesBySkillDriveId, Skill skill) {
		return (float) skill.getSkillDifficult() / (float) filesBySkillDriveId.size();
	}
}
