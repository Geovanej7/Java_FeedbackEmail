package com.br.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class EmailApplication {

	public static void main(String[] args) {
		// Carrega as variáveis do .env
		Dotenv dotenv = Dotenv.load();

		// Define como variáveis do sistema (tem que ser antes de iniciar o Spring)
		System.setProperty("EMAIL_USER", dotenv.get("EMAIL_USER"));
		System.setProperty("EMAIL_PASSWORD", dotenv.get("EMAIL_PASSWORD"));

		// Inicia a aplicação Spring Boot
		SpringApplication.run(EmailApplication.class, args);
	}

}
