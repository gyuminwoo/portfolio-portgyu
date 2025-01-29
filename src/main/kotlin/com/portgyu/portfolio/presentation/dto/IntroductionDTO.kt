package com.portgyu.portfolio.presentation.dto

import com.portgyu.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content: String
) {
    constructor(introduction: Introduction): this(
        content = introduction.content
    )
}