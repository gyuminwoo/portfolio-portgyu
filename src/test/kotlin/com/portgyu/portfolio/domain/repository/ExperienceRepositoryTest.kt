package com.portgyu.portfolio.domain.repository

import com.portgyu.portfolio.domain.entity.Experience
import com.portgyu.portfolio.domain.entity.ExperienceDetail
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest(@Autowired val experienceRepository: ExperienceRepository) {
    val DATA_SIZE = 10
    private val log = LoggerFactory.getLogger(this.javaClass)!!
    private fun createExperience(n: Int): Experience {
        val experience = Experience(
            title = "${n}",
            description = "테스트 설명 ${n}",
            startYear = 2025,
            startMonth = 1,
            endYear = 2025,
            endMonth = 1,
            isActive = true
        )

        val details = mutableListOf<ExperienceDetail>()
        for(i in 1..n) {
            val experienceDetail = ExperienceDetail(content = "테스트${i}", isActive = true)
            details.add(experienceDetail)
        }
        experience.addDetails(details)

        return experience
    }

    @BeforeAll
    fun beforeAll() {
        log.info("--- 데이터 초기화 이전 조회 시작 ---")
        val beforeInitialize = experienceRepository.findAll()
        assertThat(beforeInitialize).hasSize(0)
        log.info("--- 데이터 초기화 이전 조회 종료 ---")

        log.info("--- 테스트 데이터 초기화 시작 ---")
        val experiences = mutableListOf<Experience>()
        for(i in 1..DATA_SIZE) {
            val experience = createExperience(i)
            experiences.add(experience)
        }
        experienceRepository.saveAll(experiences)
        log.info("--- 테스트 데이터 초기화 종료 ---")
    }

    @Test
    fun testFindAll() {
        log.info("--- findAll 테스트 시작 ---")
        val experiences = experienceRepository.findAll()
        assertThat(experiences).hasSize(DATA_SIZE)
        log.info("experiences.size: ${experiences.size}")

        for (experience in experiences) {
            assertThat(experience.details).hasSize(experience.title.toInt())
            log.info("experiences.details.size: ${experience.details.size}")
        }

        log.info("--- findAll 테스트 시작 ---")

    }

    @Test
    fun testFindAllByIsActive() {
        log.info("--- findAllByIsActive 테스트 시작 ---")
        val experiences = experienceRepository.findAllByIsActive(true)
        assertThat(experiences).hasSize(DATA_SIZE)
        log.info("experiences.size: ${experiences.size}")

        for (experience in experiences) {
            assertThat(experience.details).hasSize(experience.title.toInt())
            log.info("experiences.details.size: ${experience.details.size}")
        }

        log.info("--- findAllByIsActive 테스트 종료 ---")

    }
}