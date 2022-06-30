package br.com.localdemo.forum.application.handlers

import br.com.localdemo.forum.domain.dto.TopicQuestionView
import br.com.localdemo.forum.domain.dto.UpdateTopicCommand
import br.com.localdemo.forum.domain.entities.TopicQuestion
import br.com.localdemo.forum.domain.interfaces.handlers.UpdateTopicHandler
import br.com.localdemo.forum.domain.interfaces.repositories.TopicRepository
import br.com.localdemo.forum.domain.mappers.TopicViewMapper
import org.springframework.stereotype.Service

@Service
class UpdateTopicHandlerImpl(
    private val topicRepository: TopicRepository,
    private val topicViewMapper: TopicViewMapper
) : UpdateTopicHandler {

    override fun update(updateTopicCommand: UpdateTopicCommand): TopicQuestionView {
        val topic = topicRepository.getById(updateTopicCommand.id)
        topicRepository.remove(topic)

        val updatedTopic = TopicQuestion(
            id = topic.id,
            title = updateTopicCommand.title,
            message = updateTopicCommand.message,
            course = topic.course,
            status = topic.status,
            author = topic.author,
            createdDate = topic.createdDate,
            answers = topic.answers
        )

        topicRepository.save(updatedTopic)

        return topicViewMapper.map(updatedTopic)
    }
}