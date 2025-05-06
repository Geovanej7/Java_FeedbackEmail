package com.br.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.email.model.dto.FeedbackDto;
import com.br.email.service.EmailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<String> enviarFeedback(@RequestBody @Valid FeedbackDto dto) {
        emailService.enviarEmailFeedback(dto);
        return ResponseEntity.ok("{\"message\":\"Mensagem enviada com sucesso!\"}");

    }
}
