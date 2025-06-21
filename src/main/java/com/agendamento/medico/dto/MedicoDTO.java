package com.agendamento.medico.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
public class MedicoDTO {

    @NotBlank
    @JsonProperty("nomeMedico")
    private String nomeMedico;

    @NotBlank
    @JsonProperty("crm")
    private String crm;

    @NotBlank
    @JsonProperty("especialidade")
    private String especialidade;

    @ElementCollection
    private List<LocalTime> agenda;


}
