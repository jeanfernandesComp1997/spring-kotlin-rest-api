package br.com.localdemo.forum.domain.interfaces.repositories

import br.com.localdemo.forum.domain.entities.User

interface UserRepository {

    fun getById(id: Long): User
}