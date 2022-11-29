package br.com.localdemo.forum.application.handlers

import br.com.localdemo.forum.domain.dto.TopicQuestionView
import br.com.localdemo.forum.application.commands.UpdateTopicCommand

interface UpdateTopicHandler {

    fun update(updateTopicCommand: UpdateTopicCommand): TopicQuestionView
}