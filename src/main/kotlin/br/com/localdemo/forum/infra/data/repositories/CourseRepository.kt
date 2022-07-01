package br.com.localdemo.forum.infra.data.repositories

import br.com.localdemo.forum.domain.entities.Course
import org.springframework.data.jpa.repository.JpaRepository

interface CourseRepository : JpaRepository<Course, Long> {
}