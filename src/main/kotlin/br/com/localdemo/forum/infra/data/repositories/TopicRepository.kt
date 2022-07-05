package br.com.localdemo.forum.infra.data.repositories

import br.com.localdemo.forum.domain.entities.TopicQuestion
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<TopicQuestion, Long> {

    fun findByCourseName(courseName: String, pagination: Pageable): Page<TopicQuestion>
}