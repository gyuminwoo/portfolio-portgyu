package com.portgyu.portfolio.admin.context.skill.service

import com.portgyu.portfolio.admin.data.TableDTO
import com.portgyu.portfolio.domain.entity.Skill
import com.portgyu.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Service

@Service
class AdminSkillService(
    private val skillRepository: SkillRepository
) {
    fun getSkillTable(): TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}