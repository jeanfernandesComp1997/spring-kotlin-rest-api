package br.com.localdemo.forum.application.queries.impl

import br.com.localdemo.forum.application.queries.TopicQueries
import br.com.localdemo.forum.domain.dto.TopicByCategoryDto
import br.com.localdemo.forum.domain.dto.TopicQuestionView
import br.com.localdemo.forum.infra.data.repositories.TopicRepository
import br.com.localdemo.forum.domain.mappers.TopicViewMapper
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class TopicQueriesImpl(
    private val topicRepository: TopicRepository,
    private val topicViewMapper: TopicViewMapper,
    // private val em: EntityManager Caso precisarmos utilizar o Entity Manager
) : TopicQueries {

    @Cacheable(cacheNames = ["topics"], key = "#root.method.name")
    override fun list(
        courseName: String?,
        pagination: Pageable
    ): Page<TopicQuestionView> {
        val topics = if (courseName == null) {
            topicRepository.findAll(pagination)
        } else {
            topicRepository.findByCourseName(courseName, pagination)
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

    override fun report(): List<TopicByCategoryDto> {
        return topicRepository.report()
    }
}