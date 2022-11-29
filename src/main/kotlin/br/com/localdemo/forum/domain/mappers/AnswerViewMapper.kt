package br.com.localdemo.forum.domain.mappers

import br.com.localdemo.forum.domain.dto.AnswerView
import br.com.localdemo.forum.domain.entities.Answer
import org.springframework.stereotype.Component

@Component
class AnswerViewMapper : Mapper<Answer, AnswerView> {

    override fun map(a: Answer): AnswerView {
        return AnswerView(
            id = a.id,
            message = a.message,
            createdDate = a.createdDate,
            author = a.author,
            topic = a.topic,
            solution = a.solution
        )
    }
}