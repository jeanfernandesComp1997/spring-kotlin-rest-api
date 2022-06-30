package br.com.localdemo.forum.domain.entities

import java.time.LocalDateTime
import javax.persistence.*

@Entity
data class Answer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val message: String,
    val createdDate: LocalDateTime = LocalDateTime.now(),
    @ManyToOne()
    val author: User,
    @ManyToOne
    val topic: TopicQuestion,
    val solution: Boolean
)
