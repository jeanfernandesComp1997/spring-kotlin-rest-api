package br.com.localdemo.forum.application.queries.impl

import br.com.localdemo.forum.application.queries.UserQueries
import br.com.localdemo.forum.domain.entities.Person
import br.com.localdemo.forum.domain.entities.UserDetail
import br.com.localdemo.forum.infra.data.repositories.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserQueriesImpl(
    private val repository: UserRepository
) : UserQueries, UserDetailsService {

    override fun getPersonById(id: Long): Person {
        return repository.getReferenceById(id)
    }

    override fun loadUserByUsername(username: String): UserDetails {
        val user = repository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(user)
    }
}