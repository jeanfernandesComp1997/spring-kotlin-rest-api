package br.com.localdemo.forum.application.handlers

import br.com.localdemo.forum.application.commands.RegisterTopicCommand
import br.com.localdemo.forum.domain.entities.Course
import br.com.localdemo.forum.domain.entities.TopicQuestion
import br.com.localdemo.forum.domain.entities.User
import br.com.localdemo.forum.domain.interfaces.handlers.RegisterTopicHandler
import br.com.localdemo.forum.domain.interfaces.repositories.CourseRepository
import br.com.localdemo.forum.domain.interfaces.repositories.TopicRepository
import org.springframework.stereotype.Service

@Service
class RegisterTopicHandlerImpl(
    private val topicRepository: TopicRepository,
    private val courseRepository: CourseRepository
) : RegisterTopicHandler {

    override fun register(registerTopicCommand: RegisterTopicCommand) {
        val course = courseRepository.getById(registerTopicCommand.courseId)

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