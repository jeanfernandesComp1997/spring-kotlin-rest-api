package br.com.localdemo.forum.domain.entities

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Person(
    @Id
    val id: Long? = null,
    val name: String,
    val email: String
)
