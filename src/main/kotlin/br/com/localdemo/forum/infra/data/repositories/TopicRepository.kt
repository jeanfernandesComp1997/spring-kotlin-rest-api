package br.com.localdemo.forum.infra.data.repositories

import br.com.localdemo.forum.domain.dto.TopicByCategoryDto
import br.com.localdemo.forum.domain.entities.TopicQuestion
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository : JpaRepository<TopicQuestion, Long> {

    fun findByCourseName(courseName: String, pagination: Pageable): Page<TopicQuestion>

    @Query("SELECT new br.com.localdemo.forum.domain.dto.TopicByCategoryDto(course.category, count(t)) FROM TopicQuestion t JOIN t.course course GROUP BY course.category")
    fun report(): List<TopicByCategoryDto>
}