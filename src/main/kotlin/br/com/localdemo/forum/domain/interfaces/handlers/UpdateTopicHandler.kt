package br.com.localdemo.forum.domain.interfaces.handlers

import br.com.localdemo.forum.domain.dto.UpdateTopicCommand

interface UpdateTopicHandler {

    fun update(updateTopicCommand: UpdateTopicCommand)
}