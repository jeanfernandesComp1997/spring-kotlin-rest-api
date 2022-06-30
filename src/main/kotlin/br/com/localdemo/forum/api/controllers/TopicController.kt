package br.com.localdemo.forum.api.controllers

import br.com.localdemo.forum.application.commands.RegisterTopicCommand
import br.com.localdemo.forum.domain.dto.TopicQuestionView
import br.com.localdemo.forum.domain.dto.UpdateTopicCommand
import br.com.localdemo.forum.domain.interfaces.handlers.RegisterTopicHandler
import br.com.localdemo.forum.domain.interfaces.handlers.RemoveTopicHandler
import br.com.localdemo.forum.domain.interfaces.handlers.UpdateTopicHandler
import br.com.localdemo.forum.domain.interfaces.queries.TopicQueries
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("topics")
class TopicController(
    private val topicQueries: TopicQueries,
    private val registerTopicHandler: RegisterTopicHandler,
    private val updateTopicHandler: UpdateTopicHandler,
    private val removeTopicHandler: RemoveTopicHandler
) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun list(): List<TopicQuestionView> {
        return topicQueries.list()
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    fun getById(@PathVariable id: Long): TopicQuestionView {
        return topicQueries.getById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun register(
        @RequestBody @Valid command: RegisterTopicCommand,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<TopicQuestionView> {
        val topic = registerTopicHandler.register(command)
        val uri = uriBuilder.path("/topics/${topic.id}").build().toUri()

        return ResponseEntity.created(uri).body(topic)
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun update(@RequestBody @Valid command: UpdateTopicCommand): ResponseEntity<TopicQuestionView> {
        val topic = updateTopicHandler.update(command)
        return ResponseEntity.ok(topic)
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun remove(@PathVariable id: Long) {
        removeTopicHandler.remove(id)
    }
}