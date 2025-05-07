package com.github.ssaraolimpio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class Consulta {

    @Id
    private Long id;

    @NotBlank
    private String data;

    @NotBlank
    private String hora;

    @NotBlank
    private Medico medico;

    @NotBlank
    private Paciente paciente;

}
