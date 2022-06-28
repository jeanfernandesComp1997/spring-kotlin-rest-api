package br.com.localdemo.forum.domain.interfaces

import br.com.localdemo.forum.application.commands.RegisterTopicCommand

interface RegisterTopicHandler {

    fun register(registerTopicCommand: RegisterTopicCommand)
}