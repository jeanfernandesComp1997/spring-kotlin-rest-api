package br.com.localdemo.forum.application.commands

data class RegisterTopicCommand(
    val title: String,
    val message: String,
    val courseId: Long,
    val authorId: Long
)