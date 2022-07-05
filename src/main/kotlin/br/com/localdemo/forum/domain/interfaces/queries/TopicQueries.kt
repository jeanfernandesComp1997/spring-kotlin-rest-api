package br.com.localdemo.forum.domain.interfaces.queries

import br.com.localdemo.forum.domain.dto.TopicByCategoryDto
import br.com.localdemo.forum.domain.dto.TopicQuestionView
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface TopicQueries {

    fun list(
        courseName: String?,
        pagination: Pageable
    ): Page<TopicQuestionView>

    fun getById(id: Long): TopicQuestionView

    fun report(): List<TopicByCategoryDto>
}