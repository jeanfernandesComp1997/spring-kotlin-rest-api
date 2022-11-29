package br.com.localdemo.forum.infra.data.repositories

import br.com.localdemo.forum.domain.entities.Answer
import org.springframework.data.jpa.repository.JpaRepository

interface AnswerRepository: JpaRepository<Answer, Long>