package br.com.localdemo.forum.application.queries

import br.com.localdemo.forum.domain.dto.TopicQuestionView
import br.com.localdemo.forum.domain.interfaces.queries.TopicQueries
import br.com.localdemo.forum.domain.interfaces.repositories.TopicRepository
import br.com.localdemo.forum.domain.mappers.TopicViewMapper
import org.springframework.stereotype.Service

@Service
class TopicQueriesImpl(
    private val topicRepository: TopicRepository,
    private val topicViewMapper: TopicViewMapper
) : TopicQueries {

    override fun list(): List<TopicQuestionView> {
        return topicRepository.list().map { topic ->
            topicViewMapper.map(topic)
        }
    }

    override fun getById(id: Long): TopicQuestionView {
        return topicRepository.getById(id).let { topic ->
            topicViewMapper.map(topic)
        }
    }
}