package br.com.localdemo.forum.application.handlers

import br.com.localdemo.forum.domain.dto.UpdateTopicCommand
import br.com.localdemo.forum.domain.entities.TopicQuestion
import br.com.localdemo.forum.domain.interfaces.handlers.UpdateTopicHandler
import br.com.localdemo.forum.domain.interfaces.repositories.TopicRepository
import org.springframework.stereotype.Service

@Service
class UpdateTopicHandlerImpl(
    private val topicRepository: TopicRepository,
) : UpdateTopicHandler {

    override fun update(updateTopicCommand: UpdateTopicCommand) {
        val topic = topicRepository.getById(updateTopicCommand.id)
        topicRepository.remove(topic)
        topicRepository.save(
            TopicQuestion(
                id = topic.id,
                title = updateTopicCommand.title,
                message = updateTopicCommand.message,
                course = topic.course,
                status = topic.status,
                author = topic.author,
                createdDate = topic.createdDate,
                answers = topic.answers
            )
        )
    }
}