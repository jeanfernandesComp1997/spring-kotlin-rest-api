package br.com.localdemo.forum.application.commands

import br.com.localdemo.forum.domain.entities.Course
import br.com.localdemo.forum.domain.entities.User

data class RegisterTopicCommand(
    val id: Long? = null,
    val title: String,
    val message: String,
    val course: Course,
    val author: User
)