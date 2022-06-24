package br.com.localdemo.forum.domain.interfaces

import br.com.localdemo.forum.domain.entities.TopicQuestion

interface TopicQueries {

    fun list(): List<TopicQuestion>
    fun getById(id: Long): TopicQuestion
}