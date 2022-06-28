package br.com.localdemo.forum.domain.interfaces.repositories

import br.com.localdemo.forum.domain.entities.TopicQuestion

interface TopicRepository {

    fun save(topic: TopicQuestion): Boolean
    fun getById(id: Long): TopicQuestion
    fun list(): List<TopicQuestion>
}