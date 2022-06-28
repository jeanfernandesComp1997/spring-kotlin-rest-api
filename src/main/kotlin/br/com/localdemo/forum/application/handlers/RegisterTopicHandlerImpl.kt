package br.com.localdemo.forum.application.handlers

import br.com.localdemo.forum.application.commands.RegisterTopicCommand
import br.com.localdemo.forum.domain.entities.Course
import br.com.localdemo.forum.domain.entities.TopicQuestion
import br.com.localdemo.forum.domain.entities.User
import br.com.localdemo.forum.domain.interfaces.RegisterTopicHandler
import br.com.localdemo.forum.domain.interfaces.TopicRepository
import org.springframework.stereotype.Service

@Service
class RegisterTopicHandlerImpl(
    private val topicRepository: TopicRepository
) : RegisterTopicHandler {

    override fun register(registerTopicCommand: RegisterTopicCommand) {
        val course = Course(
            id = registerTopicCommand.courseId,
            name = "test",
            category = "test"
        )

        val author = User(
            id = registerTopicCommand.authorId,
            name = "Jean",
            email = "jean@email.com"
        )

        val topicQuestion = TopicQuestion.createNewTopicQuestion(
            registerTopicCommand.title,
            registerTopicCommand.message,
            course,
            author
        )

        topicRepository.save(topicQuestion)
    }
}