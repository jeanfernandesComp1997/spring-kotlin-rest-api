package br.com.localdemo.forum.domain.interfaces.queries

import br.com.localdemo.forum.domain.entities.TopicQuestion

interface TopicQueries {

    fun list(): List<TopicQuestion>
    fun getById(id: Long): TopicQuestion
}