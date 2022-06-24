package br.com.localdemo.forum.domain.entities

import br.com.localdemo.forum.domain.enums.TopicStatus
import java.time.LocalDateTime

data class TopicQuestion(
    val id: Long? = null,
    val title: String,
    val message: String,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val course: Course,
    val author: User,
    val status: TopicStatus = TopicStatus.PENDING,
    val answers: List<Answer> = listOf()
)