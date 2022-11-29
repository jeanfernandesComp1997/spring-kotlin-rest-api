package br.com.localdemo.forum.application.commands

import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class RegisterAnswerCommand(
    @field:NotEmpty
    @field:Size(min = 5, max = 1000)
    val message: String,
    @field:NotNull
    val authorId: Long,
    @field:NotNull
    val topicId: Long
)