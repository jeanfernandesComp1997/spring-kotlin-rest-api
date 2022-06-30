package br.com.localdemo.forum.application.handlers

import br.com.localdemo.forum.domain.interfaces.handlers.RemoveTopicHandler
import br.com.localdemo.forum.domain.interfaces.repositories.TopicRepository
import org.springframework.stereotype.Service

@Service
class RemoveTopicHandlerImpl(
    private val topicRepository: TopicRepository
) : RemoveTopicHandler {

    override fun remove(id: Long) {
        val topic = topicRepository.getById(id)
        topicRepository.remove(topic)
    }
}