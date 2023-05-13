package br.com.localdemo.forum.controller

import br.com.localdemo.forum.api.controllers.AnswerController
import br.com.localdemo.forum.application.handlers.AnswerTopicHandler
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get


@WebMvcTest(AnswerController::class)
class AnswerControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var answerTopicHandler: AnswerTopicHandler

    @Test
    fun greetingShouldReturnMessageFromService() {
        val result = mockMvc.perform(get("/answers/greeting")).andReturn()

        Assertions.assertEquals(401, result.response.status)
    }
}