package com.portgyu.portfolio.domain.repository

import com.portgyu.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository

interface ProjectRepository:JpaRepository<Project, Long> {
    
}