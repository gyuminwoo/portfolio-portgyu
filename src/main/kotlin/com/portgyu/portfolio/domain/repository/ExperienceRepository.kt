package com.portgyu.portfolio.domain.repository

import com.portgyu.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository

interface ExperienceRepository:JpaRepository<Experience, Long> {
    
}