package br.com.localdemo.forum.domain.interfaces.handlers

import br.com.localdemo.forum.application.commands.RegisterTopicCommand

interface RegisterTopicHandler {

    fun register(registerTopicCommand: RegisterTopicCommand)
}