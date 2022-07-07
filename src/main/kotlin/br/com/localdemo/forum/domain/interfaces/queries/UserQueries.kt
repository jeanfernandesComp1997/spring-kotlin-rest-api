package br.com.localdemo.forum.domain.interfaces.queries

import br.com.localdemo.forum.domain.entities.Person

interface UserQueries {

    fun getPersonById(id: Long): Person
}