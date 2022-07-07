package br.com.localdemo.forum.domain.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToMany

@Entity
data class Person(
    @Id
    val id: Long? = null,
    val name: String,
    val email: String,
    val password: String,

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_role")
    val role: List<Role> = mutableListOf()
)
