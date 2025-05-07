package com.github.ssaraolimpio.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.persistence.Id;

@Entity
@Data
public class Paciente {

    @Id
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cpf;


}
