package br.com.localdemo.forum.application.queries

import br.com.localdemo.forum.domain.dto.TopicQuestionView
import br.com.localdemo.forum.domain.interfaces.queries.TopicQueries
import br.com.localdemo.forum.domain.interfaces.repositories.TopicRepository
import org.springframework.stereotype.Service

@Service
class TopicQueriesImpl(
    private val topicRepository: TopicRepository
) : TopicQueries {

    override fun list(): List<TopicQuestionView> {
        return topicRepository.list().map { topic ->
            TopicQuestionView(
                id = topic.id,
                title = topic.title,
                message = topic.message,
                status = topic.status,
                createdDate = topic.createdDate
            )
        }
    }

    override fun getById(id: Long): TopicQuestionView {
        return topicRepository.getById(id).let { topic ->
            TopicQuestionView(
                id = topic.id,
                title = topic.title,
                message = topic.message,
                status = topic.status,
                createdDate = topic.createdDate
            )
        }
    }
}