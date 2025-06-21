package com.agendamento.medico.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ConsultaResponseDTO {

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
