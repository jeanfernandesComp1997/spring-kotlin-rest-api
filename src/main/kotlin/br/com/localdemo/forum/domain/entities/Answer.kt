package br.com.localdemo.forum.domain.entities

import br.com.localdemo.forum.domain.enums.TopicStatus
import java.time.LocalDateTime
import javax.persistence.*
import kotlin.random.Random

@Entity
class Answer(
    id: Long,
    message: String,
    createdDate: LocalDateTime,
    author: Person,
    topic: TopicQuestion,
    solution: Boolean
) {
    @Id
    var id: Long = id
        private set

    var message: String = message
        private set
    var createdDate: LocalDateTime = createdDate
        private set

    @ManyToOne()
    var author: Person = author
        private set

    @ManyToOne
    var topic: TopicQuestion = topic
        private set

    var solution: Boolean = solution
        private set

    companion object {
        fun createAnswer(message: String, author: Person, topic: TopicQuestion): Answer {
            return Answer(
                id = Random.nextLong(0, Long.MAX_VALUE),
                message = message,
                createdDate = LocalDateTime.now(),
                author = author,
                topic = topic,
                solution = false
            )
        }
    }

    fun setAsASolution(isTheSolution: Boolean) {
        solution = isTheSolution
    }
}