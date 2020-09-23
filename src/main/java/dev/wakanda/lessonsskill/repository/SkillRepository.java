package dev.wakanda.lessonsskill.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.wakanda.lessonsskill.domain.Skill;

public interface SkillRepository extends JpaRepository<Skill,Long> {

}
