package com.portgyu.portfolio.domain.repository

import com.portgyu.portfolio.domain.entity.Link
import org.springframework.data.jpa.repository.JpaRepository

interface LinkRepository:JpaRepository<Link, Long> {
    
}