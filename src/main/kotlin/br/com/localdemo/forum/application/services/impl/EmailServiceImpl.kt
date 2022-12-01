package br.com.localdemo.forum.application.services.impl

import br.com.localdemo.forum.application.services.EmailService
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailServiceImpl(
    private val javaMailSender: JavaMailSender
) : EmailService {

    override fun sendNotification() {
        val message = generateEmail()
        javaMailSender.send(message)
    }

    private fun generateEmail(): SimpleMailMessage {
        val message = SimpleMailMessage()

        message.setSubject("")
        message.setText("")
        message.setTo("")

        return message
    }
}