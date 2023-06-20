package com.mohamadjavad.link.email

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailService(private val mailSender: JavaMailSender) {

    fun sendEmail(to: String, subject: String, body: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val message = SimpleMailMessage().apply {
                setTo(to)
                this.subject = subject
                this.text = body
            }
            mailSender.send(message)
        }
    }

    fun sendAuthenticationEmail(email: String, code: String) {
        sendEmail(
            to = email,
            subject = "Authentication Code",
            body = "welcome, here is your authentication code:\n${code}"
        )
    }
}