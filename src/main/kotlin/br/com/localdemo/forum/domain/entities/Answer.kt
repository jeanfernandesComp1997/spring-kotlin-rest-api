package br.com.localdemo.forum.domain.entities

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Answer(
    @Id
    val id: Long? = null,
    val message: String,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne()
    val author: Person,
    @ManyToOne
    val topic: TopicQuestion,
    val solution: Boolean
)
