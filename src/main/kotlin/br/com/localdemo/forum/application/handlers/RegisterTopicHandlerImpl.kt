package br.com.localdemo.forum.application.handlers

import br.com.localdemo.forum.application.commands.RegisterTopicCommand
import br.com.localdemo.forum.domain.dto.TopicQuestionView
import br.com.localdemo.forum.domain.entities.TopicQuestion
import br.com.localdemo.forum.domain.interfaces.handlers.RegisterTopicHandler
import br.com.localdemo.forum.domain.interfaces.repositories.CourseRepository
import br.com.localdemo.forum.domain.interfaces.repositories.TopicRepository
import br.com.localdemo.forum.domain.interfaces.repositories.UserRepository
import br.com.localdemo.forum.domain.mappers.TopicViewMapper
import org.springframework.stereotype.Service

@Service
class RegisterTopicHandlerImpl(
    private val topicRepository: TopicRepository,
    private val courseRepository: CourseRepository,
    private val userRepository: UserRepository,
    private val topicViewMapper: TopicViewMapper
) : RegisterTopicHandler {

    override fun register(registerTopicCommand: RegisterTopicCommand): TopicQuestionView {
        val course = courseRepository.getById(registerTopicCommand.courseId)
        val author = userRepository.getById(registerTopicCommand.authorId)

        val topicQuestion = TopicQuestion.createNewTopicQuestion(
            registerTopicCommand.title,
            registerTopicCommand.message,
            course,
            author
        )

        topicRepository.save(topicQuestion)

        return topicViewMapper.map(topicQuestion)
    }
}