package com.github.ssaraolimpio.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PacienteDTO {

    @Id
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;



}
