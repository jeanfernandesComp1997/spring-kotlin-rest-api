package br.com.localdemo.forum.infra.data.repositories

import br.com.localdemo.forum.domain.entities.TopicQuestion
import br.com.localdemo.forum.domain.exceptions.NotFoundException
import org.springframework.stereotype.Service

//@Service
//class TopicRepositoryImpl : TopicRepository {
//
//    private val topics: List<TopicQuestion> get() = data.toList()
//    private val notFoundMessage = "Topic NotFound"
//
//    companion object {
//        private val data = mutableListOf<TopicQuestion>()
//    }
//
//    override fun save(topic: TopicQuestion): Boolean {
//        data.add(topic)
//        return true
//    }
//
//    override fun getById(id: Long): TopicQuestion {
//        try {
//            return topics.first { topic ->
//                topic.id == id
//            }
//        } catch (e: Exception) {
//            throw NotFoundException(notFoundMessage)
//        }
//    }
//
//    override fun list(): List<TopicQuestion> {
//        return topics
//    }
//
//    override fun remove(topic: TopicQuestion): Boolean {
//        data.remove(topic)
//        return true
//    }
//}