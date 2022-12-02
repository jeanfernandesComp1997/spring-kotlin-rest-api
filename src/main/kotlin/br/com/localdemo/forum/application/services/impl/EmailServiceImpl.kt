package br.com.localdemo.forum.application.services.impl

import br.com.localdemo.forum.application.services.EmailService
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailServiceImpl(
    private val javaMailSender: JavaMailSender
) : EmailService {

    override fun sendNotification(authorEmail: String) {
        val message = generateEmail(authorEmail)
        javaMailSender.send(message)
    }

    private fun generateEmail(authorEmail: String): SimpleMailMessage {
        val message = SimpleMailMessage()

        message.setSubject("[Course Plataform] Received answer")
        message.setText("Hi, your question was answered! Let's check it?")
        message.setTo(authorEmail)

        return message
    }
}