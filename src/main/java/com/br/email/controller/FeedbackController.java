package com.br.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.email.model.dto.FeedbackDto;
import com.br.email.service.EmailService;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*") 
public class FeedbackController {
     @Autowired
    private EmailService emailService;

    @PostMapping
    public String enviarFeedback(@RequestBody FeedbackDto dto) {
        return emailService.enviarEmailFeedback(dto);
    }
}
