package com.agendamento.medico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBaseProjectApplication {
    public static void main(String[] args) {
        System.out.println(">>> Aplicação iniciando...");
        SpringApplication.run(SpringBootBaseProjectApplication.class, args);
    }
}

