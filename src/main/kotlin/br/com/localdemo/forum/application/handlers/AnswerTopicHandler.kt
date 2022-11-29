package br.com.localdemo.forum.application.handlers

import br.com.localdemo.forum.application.commands.RegisterAnswerCommand
import br.com.localdemo.forum.domain.dto.AnswerView

interface AnswerTopicHandler {

    fun registerAnswer(registerAnswerCommand: RegisterAnswerCommand): AnswerView
}