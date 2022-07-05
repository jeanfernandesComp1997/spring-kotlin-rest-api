package br.com.localdemo.forum.application.queries

import br.com.localdemo.forum.domain.dto.TopicQuestionView
import br.com.localdemo.forum.domain.interfaces.queries.TopicQueries
import br.com.localdemo.forum.infra.data.repositories.TopicRepository
import br.com.localdemo.forum.domain.mappers.TopicViewMapper
import org.springframework.stereotype.Service

@Service
class TopicQueriesImpl(
    private val topicRepository: TopicRepository,
    private val topicViewMapper: TopicViewMapper
) : TopicQueries {

    override fun list(courseName: String?): List<TopicQuestionView> {
        val topics = if (courseName == null) {
            topicRepository.findAll()
        } else {
            topicRepository.findByCourseName(courseName)
        }

        return topics.map { topic ->
            topicViewMapper.map(topic)
        }
    }

    override fun getById(id: Long): TopicQuestionView {
        val topic = topicRepository.getReferenceById(id)

        return topicRepository.getReferenceById(id).let { topic ->
            topicViewMapper.map(topic)
        }
    }
}