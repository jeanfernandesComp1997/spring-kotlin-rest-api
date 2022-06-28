package br.com.localdemo.forum.domain.interfaces.queries

import br.com.localdemo.forum.domain.dto.TopicQuestionView

interface TopicQueries {

    fun list(): List<TopicQuestionView>
    fun getById(id: Long): TopicQuestionView
}