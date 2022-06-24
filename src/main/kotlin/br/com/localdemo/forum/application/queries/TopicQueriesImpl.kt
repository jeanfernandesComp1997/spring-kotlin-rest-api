package br.com.localdemo.forum.application.queries

import br.com.localdemo.forum.domain.entities.Course
import br.com.localdemo.forum.domain.entities.TopicQuestion
import br.com.localdemo.forum.domain.entities.User
import br.com.localdemo.forum.domain.interfaces.TopicQueries
import org.springframework.stereotype.Service

@Service
class TopicQueriesImpl : TopicQueries {

    private val topics: List<TopicQuestion> get() = data.toList()

    companion object {
        private val data = mutableListOf<TopicQuestion>()
    }

    init {
        val topic1 = TopicQuestion(
            id = 1,
            title = "Doubt Kotlin",
            message = "Kotlin coroutines",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programming"
            ),
            author = User(
                id = 1,
                name = "Jean Fernandes",
                email = "jean@email.com"
            )
        )

        val topic2 = TopicQuestion(
            id = 2,
            title = "Doubt Kotlin",
            message = "Kotlin coroutines",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programming"
            ),
            author = User(
                id = 1,
                name = "Jean Fernandes",
                email = "jean@email.com"
            )
        )

        val topic3 = TopicQuestion(
            id = 3,
            title = "Doubt Kotlin",
            message = "Kotlin coroutines",
            course = Course(
                id = 1,
                name = "Kotlin",
                category = "Programming"
            ),
            author = User(
                id = 1,
                name = "Jean Fernandes",
                email = "jean@email.com"
            )
        )

        data.addAll(mutableListOf(topic1, topic2, topic3))
    }

    override fun list(): List<TopicQuestion> {
        return topics
    }

    override fun getById(id: Long): TopicQuestion {
        return topics.first { topic ->
            topic.id == id
        }
    }
}