package com.portgyu.portfolio.admin.context.introduction.service

import com.portgyu.portfolio.admin.data.TableDTO
import com.portgyu.portfolio.domain.entity.Introduction
import com.portgyu.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository
) {
    fun getIntroductionTable(): TableDTO {
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo, entities)
    }
}