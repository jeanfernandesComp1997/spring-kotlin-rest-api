package br.com.localdemo.forum.application.handlers.impl

import br.com.localdemo.forum.application.commands.RegisterTopicCommand
import br.com.localdemo.forum.domain.dto.TopicQuestionView
import br.com.localdemo.forum.domain.entities.TopicQuestion
import br.com.localdemo.forum.application.handlers.RegisterTopicHandler
import br.com.localdemo.forum.infra.data.repositories.CourseRepository
import br.com.localdemo.forum.infra.data.repositories.TopicRepository
import br.com.localdemo.forum.infra.data.repositories.UserRepository
import br.com.localdemo.forum.domain.mappers.TopicViewMapper
import org.springframework.cache.annotation.CacheEvict
import org.springframework.stereotype.Service

@Service
class RegisterTopicHandlerImpl(
    private val topicRepository: TopicRepository,
    private val courseRepository: CourseRepository,
    private val userRepository: UserRepository,
    private val topicViewMapper: TopicViewMapper
) : RegisterTopicHandler {

    @CacheEvict(value = ["topics"], allEntries = true)
    override fun register(registerTopicCommand: RegisterTopicCommand): TopicQuestionView {
        val course = courseRepository.getReferenceById(registerTopicCommand.courseId)
        val author = userRepository.getReferenceById(registerTopicCommand.authorId)

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