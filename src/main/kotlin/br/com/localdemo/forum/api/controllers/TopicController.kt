package br.com.localdemo.forum.api.controllers

import br.com.localdemo.forum.domain.entities.TopicQuestion
import br.com.localdemo.forum.domain.interfaces.TopicQueries
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("topics")
class TopicController(
    private val topicQueries: TopicQueries
) {

    @GetMapping
    fun list(): ResponseEntity<List<TopicQuestion>> {
        return ResponseEntity.ok(topicQueries.list())
    }

    @GetMapping("{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<TopicQuestion> {
        return ResponseEntity.ok(topicQueries.getById(id))
    }
}