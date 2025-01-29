package com.portgyu.portfolio.presentation.dto

import com.portgyu.portfolio.domain.entity.ProjectDetail

data class ProjectDetailDTO(
    val content: String,
    val url: String?
) {
    constructor(projectDetail: ProjectDetail): this(
        content = projectDetail.content,
        url = projectDetail.url
    )
}