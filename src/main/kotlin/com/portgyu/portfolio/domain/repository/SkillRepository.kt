package com.portgyu.portfolio.domain.repository

import com.portgyu.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository

interface SkillRepository:JpaRepository<Skill, Long> {

}
