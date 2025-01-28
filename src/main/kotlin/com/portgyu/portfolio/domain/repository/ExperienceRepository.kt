package com.portgyu.portfolio.domain.repository

import com.portgyu.portfolio.domain.entity.Experience
import com.portgyu.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository:JpaRepository<Experience, Long> {
    fun findAllByIsActive(isActive: Boolean): List<Experience>
}