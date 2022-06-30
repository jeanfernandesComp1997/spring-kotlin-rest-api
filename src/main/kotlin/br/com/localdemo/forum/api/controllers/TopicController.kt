package br.com.localdemo.forum.api.controllers

import br.com.localdemo.forum.application.commands.RegisterTopicCommand
import br.com.localdemo.forum.domain.dto.TopicQuestionView
import br.com.localdemo.forum.domain.dto.UpdateTopicCommand
import br.com.localdemo.forum.domain.interfaces.handlers.RegisterTopicHandler
import br.com.localdemo.forum.domain.interfaces.handlers.UpdateTopicHandler
import br.com.localdemo.forum.domain.interfaces.queries.TopicQueries
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("topics")
class TopicController(
    private val topicQueries: TopicQueries,
    private val registerTopicHandler: RegisterTopicHandler,
    private val updateTopicHandler: UpdateTopicHandler
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
    fun register(@RequestBody @Valid command: RegisterTopicCommand) {
        registerTopicHandler.register(command)
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    fun update(@RequestBody @Valid command: UpdateTopicCommand) {
        updateTopicHandler.update(command)
    }
}