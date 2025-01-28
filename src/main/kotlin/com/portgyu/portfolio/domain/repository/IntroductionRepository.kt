package com.portgyu.portfolio.domain.repository

import com.portgyu.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository

interface IntroductionRepository:JpaRepository<Introduction, Long> {
    
}