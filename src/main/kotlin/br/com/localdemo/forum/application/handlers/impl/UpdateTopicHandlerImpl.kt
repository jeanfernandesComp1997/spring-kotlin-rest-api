package br.com.localdemo.forum.application.handlers.impl

import br.com.localdemo.forum.domain.dto.TopicQuestionView
import br.com.localdemo.forum.application.commands.UpdateTopicCommand
import br.com.localdemo.forum.application.handlers.UpdateTopicHandler
import br.com.localdemo.forum.infra.data.repositories.TopicRepository
import br.com.localdemo.forum.domain.mappers.TopicViewMapper
import org.springframework.cache.annotation.CacheEvict
import org.springframework.stereotype.Service

@Service
class UpdateTopicHandlerImpl(
    private val topicRepository: TopicRepository,
    private val topicViewMapper: TopicViewMapper
) : UpdateTopicHandler {

    @CacheEvict(value = ["topics"], allEntries = true)
    override fun update(updateTopicCommand: UpdateTopicCommand): TopicQuestionView {
        val topic = topicRepository.getReferenceById(updateTopicCommand.id)
        topic.updateTitle(updateTopicCommand.title)
        topic.updateMessage(updateTopicCommand.message)

        return topicViewMapper.map(topic)
    }
}