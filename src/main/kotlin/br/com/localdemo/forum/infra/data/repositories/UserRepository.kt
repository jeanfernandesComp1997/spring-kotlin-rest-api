package br.com.localdemo.forum.infra.data.repositories

import br.com.localdemo.forum.domain.entities.Person
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<Person, Long> {
}