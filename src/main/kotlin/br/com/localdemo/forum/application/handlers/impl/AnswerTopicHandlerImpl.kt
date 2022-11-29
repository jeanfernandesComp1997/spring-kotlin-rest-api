package br.com.localdemo.forum.application.handlers.impl

import br.com.localdemo.forum.application.commands.RegisterAnswerCommand
import br.com.localdemo.forum.application.handlers.AnswerTopicHandler
import br.com.localdemo.forum.domain.dto.AnswerView
import br.com.localdemo.forum.domain.entities.Answer
import br.com.localdemo.forum.domain.mappers.AnswerViewMapper
import br.com.localdemo.forum.infra.data.repositories.AnswerRepository
import br.com.localdemo.forum.infra.data.repositories.TopicRepository
import br.com.localdemo.forum.infra.data.repositories.UserRepository
import org.springframework.cache.annotation.CacheEvict
import org.springframework.stereotype.Service

@Service
class AnswerTopicHandlerImpl(
    private val topicRepository: TopicRepository,
    private val userRepository: UserRepository,
    private val answerRepository: AnswerRepository,
    private val answerViewMapper: AnswerViewMapper,
) : AnswerTopicHandler {

    @CacheEvict(value = ["topics"], allEntries = true)
    override fun registerAnswer(registerAnswerCommand: RegisterAnswerCommand): AnswerView {
        val topic = topicRepository.getReferenceById(registerAnswerCommand.topicId)
        val author = userRepository.getReferenceById(registerAnswerCommand.authorId)

        val answer = Answer.createAnswer(
            registerAnswerCommand.message,
            author,
            topic
        )

        answerRepository.save(answer)

        return answerViewMapper.map(answer)
    }
}