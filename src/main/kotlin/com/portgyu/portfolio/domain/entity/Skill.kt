package com.portgyu.portfolio.domain.entity

import com.portgyu.portfolio.domain.constant.SkillType
import jakarta.persistence.*

@Entity
class Skill(
        name: String,
        type: String,
        isActive: Boolean
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    var id: Long? = null

    var name: String = name

//  DB 전환을 고려한 Column 이름 명시
    @Column(name = "skill_type")
    @Enumerated(value = EnumType.STRING)
    var type: SkillType = SkillType.valueOf(type)

    var isActive: Boolean = isActive
}