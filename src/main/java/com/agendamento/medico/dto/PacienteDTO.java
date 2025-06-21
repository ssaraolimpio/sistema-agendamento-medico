package com.agendamento.medico.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PacienteDTO {

    @NotBlank
    @JsonProperty("nomePaciente")
    private String nomePaciente;

    @NotBlank
    @JsonProperty("cpf")
    private String cpf;



}
