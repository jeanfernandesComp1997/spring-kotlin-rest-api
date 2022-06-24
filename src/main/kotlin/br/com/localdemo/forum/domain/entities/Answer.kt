package br.com.localdemo.forum.domain.entities

import java.time.LocalDateTime

data class Answer(
    val id: Long? = null,
    val message: String,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    val author: User,
    val topic: TopicQuestion,
    val solution: Boolean
)
