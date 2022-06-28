package br.com.localdemo.forum.application.queries

import br.com.localdemo.forum.domain.entities.TopicQuestion
import br.com.localdemo.forum.domain.interfaces.queries.TopicQueries
import br.com.localdemo.forum.domain.interfaces.repositories.TopicRepository
import org.springframework.stereotype.Service

@Service
class TopicQueriesImpl(
    private val topicRepository: TopicRepository
) : TopicQueries {

    override fun list(): List<TopicQuestion> {
        return topicRepository.list()
    }

    override fun getById(id: Long): TopicQuestion {
        return topicRepository.getById(id)
    }
}