package br.com.localdemo.forum.domain.interfaces.handlers

import br.com.localdemo.forum.application.commands.RegisterTopicCommand
import br.com.localdemo.forum.domain.dto.TopicQuestionView

interface RegisterTopicHandler {

    fun register(registerTopicCommand: RegisterTopicCommand): TopicQuestionView
}