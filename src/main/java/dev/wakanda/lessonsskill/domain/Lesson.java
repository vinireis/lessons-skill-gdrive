package dev.wakanda.lessonsskill.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dev.wakanda.lessonsskill.service.LessonGDriveFile;

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
	
	public Lesson(LessonGDriveFile gDriveFile) {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Float getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Float difficulty) {
		this.difficulty = difficulty;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public Integer getSkillSequence() {
		return skillSequence;
	}

	public void setSkillSequence(Integer skillSequence) {
		this.skillSequence = skillSequence;
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

}
