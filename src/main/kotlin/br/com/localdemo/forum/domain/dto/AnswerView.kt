package br.com.localdemo.forum.domain.dto

import br.com.localdemo.forum.domain.entities.Person
import br.com.localdemo.forum.domain.entities.TopicQuestion
import java.time.LocalDateTime

data class AnswerView(
    val id: Long,
    val message: String,
    val createdDate: LocalDateTime,
    val author: Person,
    val topic: TopicQuestion,
    val solution: Boolean
)