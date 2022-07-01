package br.com.localdemo.forum.infra.data.repositories

import br.com.localdemo.forum.domain.entities.TopicQuestion
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository : JpaRepository<TopicQuestion, Long> {
}