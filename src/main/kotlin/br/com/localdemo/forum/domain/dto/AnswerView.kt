package br.com.localdemo.forum.domain.dto

import java.time.LocalDateTime

data class AnswerView(
    val id: Long,
    val message: String,
    val createdDate: LocalDateTime,
    val author: String,
    val topic: String,
    val solution: Boolean
)