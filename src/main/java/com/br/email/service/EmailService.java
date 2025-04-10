package com.br.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.br.email.model.dto.FeedbackDto;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String remetente;

    public String enviarEmailFeedback(FeedbackDto dto) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");

            System.out.println(dto.getEmail());
            System.out.println(dto.getAssunto());
            System.out.println(dto.getMensagem());

            helper.setFrom(remetente); 
            helper.setTo(remetente);   
            helper.setReplyTo(dto.getEmail()); 
            helper.setSubject(dto.getAssunto());

            String corpoHtml = String.format(
                "<p><strong>Email do cliente:</strong> %s</p>" +
                "<p><strong>Mensagem:</strong><br>%s</p>",
                dto.getEmail(), dto.getMensagem()
            );

            helper.setText(corpoHtml, true);
            javaMailSender.send(message);

            return "Feedback enviado com sucesso!";
        } catch (Exception e) {
            return "Erro ao enviar email: " + e.getMessage();
        }
    }
}
