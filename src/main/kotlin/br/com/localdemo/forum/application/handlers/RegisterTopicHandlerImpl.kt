package br.com.localdemo.forum.application.handlers

import br.com.localdemo.forum.application.commands.RegisterTopicCommand
import br.com.localdemo.forum.domain.entities.TopicQuestion
import br.com.localdemo.forum.domain.interfaces.RegisterTopicHandler

class RegisterTopicHandlerImpl : RegisterTopicHandler {

    override fun register(registerTopicCommand: RegisterTopicCommand) {
        val topicQuestion = TopicQuestion(
            id = registerTopicCommand.id,
            title = registerTopicCommand.title,
            message = registerTopicCommand.message,
            course = registerTopicCommand.course,
            author = registerTopicCommand.author
        )
    }
}