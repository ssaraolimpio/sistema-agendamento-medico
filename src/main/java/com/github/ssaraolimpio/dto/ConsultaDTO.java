package com.github.ssaraolimpio.dto;

import com.github.ssaraolimpio.model.Medico;
import com.github.ssaraolimpio.model.Paciente;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ConsultaDTO {

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
