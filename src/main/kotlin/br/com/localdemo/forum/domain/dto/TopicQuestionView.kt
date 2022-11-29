package br.com.localdemo.forum.domain.dto

import br.com.localdemo.forum.domain.enums.TopicStatus
import java.io.Serializable
import java.time.LocalDateTime

data class TopicQuestionView(
    val id: Long,
    val title: String,
    val message: String,
    val status: TopicStatus,
    val createdDate: LocalDateTime
): Serializable