package br.com.localdemo.forum.domain.entities

import br.com.localdemo.forum.domain.enums.TopicStatus
import java.time.LocalDateTime
import kotlin.random.Random

class TopicQuestion(
    id: Long,
    title: String,
    message: String,
    createdDate: LocalDateTime,
    course: Course,
    author: User,
    status: TopicStatus,
    answers: List<Answer>
) {
    var id: Long = id
        private set

    var title: String = title
        private set

    var message: String = message
        private set

    var createdDate: LocalDateTime = createdDate
        private set

    var course: Course = course
        private set

    var author: User = author
        private set

    var status: TopicStatus = status
        private set

    var answers: List<Answer> = answers
        private set

    companion object {
        fun createNewTopicQuestion(title: String, message: String, course: Course, author: User): TopicQuestion {
            return TopicQuestion(
                id = Random.nextLong(0, Long.MAX_VALUE),
                title = title,
                message = message,
                createdDate = LocalDateTime.now(),
                course = course,
                author = author,
                status = TopicStatus.PENDING,
                answers = listOf()
            )
        }
    }
}