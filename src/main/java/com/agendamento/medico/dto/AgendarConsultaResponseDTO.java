package com.agendamento.medico.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendarConsultaResponseDTO {

    @NotNull
    @JsonProperty("id")
    private Long idConsulta;

    @JsonProperty("dataHoraConsulta")
    private String dataHoraConsulta;

    @JsonProperty("paciente")
    private String nomePaciente;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("medico")
    private String nomeMedico;

    @JsonProperty("especialidade")
    private String especialidade;


}
