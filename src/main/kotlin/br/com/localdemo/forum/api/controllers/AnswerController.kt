package br.com.localdemo.forum.api.controllers

import br.com.localdemo.forum.application.commands.RegisterAnswerCommand
import br.com.localdemo.forum.application.handlers.AnswerTopicHandler
import br.com.localdemo.forum.domain.dto.AnswerView
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid


@RestController
@RequestMapping("answers")
class AnswerController(
    private val answerTopicHandler: AnswerTopicHandler
) {

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    fun registerAnswer(
        @RequestBody @Valid command: RegisterAnswerCommand,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<AnswerView> {
        val answer = answerTopicHandler.registerAnswer(command)
        val uri = uriBuilder.path("/answers/${answer.id}").build().toUri()

        return ResponseEntity.created(uri).body(answer)
    }

    @RequestMapping("/hello")
    @ResponseBody
    fun greeting(): ResponseEntity<Any> {
        val objectHello = object {
            val greeting = "Hello guys!"
        }
        return ResponseEntity.ok(objectHello)
    }
}