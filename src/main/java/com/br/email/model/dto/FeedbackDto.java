package com.br.email.model.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class FeedbackDto {
    
    @Email(message = "Precisa ser um email valido")
    @NotBlank(message = "Esse campo é de preenchimento obrigatorio!")
    private String email;

    @NotBlank(message = "Esse campo é de preenchimento obrigatorio!")
    private String assunto;

    @NotBlank(message = "Esse campo é de preenchimento obrigatorio!")
    @Length(min = 10, max = 10000, message = "O corpo do e-mail deve ter entre 10 e 10.000 caracteres.")
    private String mensagem;

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
