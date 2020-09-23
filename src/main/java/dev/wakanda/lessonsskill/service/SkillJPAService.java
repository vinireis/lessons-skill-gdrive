package dev.wakanda.lessonsskill.service;

import org.springframework.stereotype.Service;

import dev.wakanda.lessonsskill.domain.Skill;
import dev.wakanda.lessonsskill.repository.SkillRepository;

@Service
public class SkillJPAService implements SkillService {
	SkillRepository skillRepository;

	public SkillJPAService(SkillRepository skillRepository) {
		this.skillRepository = skillRepository;
	}

	public Skill save(Skill skill) {
		return skillRepository.save(skill);
	}
}
