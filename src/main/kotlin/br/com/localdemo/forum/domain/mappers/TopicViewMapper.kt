package br.com.localdemo.forum.domain.mappers

import br.com.localdemo.forum.domain.dto.TopicQuestionView
import br.com.localdemo.forum.domain.entities.TopicQuestion
import org.springframework.stereotype.Component

@Component
class TopicViewMapper : Mapper<TopicQuestion, TopicQuestionView> {

    override fun map(t: TopicQuestion): TopicQuestionView {
        return TopicQuestionView(
            id = t.id,
            title = t.title,
            message = t.message,
            status = t.status,
            createdDate = t.createdDate
        )
    }
}