package br.com.localdemo.forum.domain.interfaces.queries

import br.com.localdemo.forum.domain.entities.Person
import org.springframework.security.core.userdetails.UserDetails

interface UserQueries {

    fun getPersonById(id: Long): Person
    fun loadUserByUsername(username: String): UserDetails
}