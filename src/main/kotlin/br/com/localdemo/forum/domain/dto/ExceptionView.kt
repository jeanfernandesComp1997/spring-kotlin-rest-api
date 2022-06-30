package br.com.localdemo.forum.domain.dto

import java.time.LocalDateTime

data class ExceptionView(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)
