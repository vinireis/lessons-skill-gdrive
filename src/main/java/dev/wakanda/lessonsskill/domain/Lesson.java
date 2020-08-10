package dev.wakanda.lessonsskill.domain;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.api.services.drive.model.File;

@Entity
@Table(name = "lessons")
public class Lesson {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length = 60, unique = true)
	private String code;
	@Column(length = 120, nullable = false)
	private String name;
	private String link;
	@Column(name = "file_id")
	private String fileId;
	private Float difficulty;
	private Integer skillSequence;
	@Column(name = "skill_id")
	private Long skillId;

	public Lesson(File gDriveFile) {
		this.name = gDriveFile.getName();
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

	public String getLink() {
		return link;
	}

	public Float getDifficulty() {
		return difficulty;
	}

	public String getFileId() {
		return fileId;
	}

	public Integer getSkillSequence() {
		return skillSequence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((fileId == null) ? 0 : fileId.hashCode());
		result = prime * result + ((skillId == null) ? 0 : skillId.hashCode());
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
		if (fileId == null) {
			if (other.fileId != null)
				return false;
		} else if (!fileId.equals(other.fileId))
			return false;
		if (skillId == null) {
			if (other.skillId != null)
				return false;
		} else if (!skillId.equals(other.skillId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lesson [code=" + code + ", name=" + name + ", fileId=" + fileId + ", difficulty=" + difficulty
				+ ", skillSequence=" + skillSequence + ", skillId=" + skillId + "]";
	}

	public static List<Lesson> convertToLessons(List<File> filesBySkillDriveId) {
		return filesBySkillDriveId.parallelStream().map(Lesson::new).collect(Collectors.toList());
	}
}
