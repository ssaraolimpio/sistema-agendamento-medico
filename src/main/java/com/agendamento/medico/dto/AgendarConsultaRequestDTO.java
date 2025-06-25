package com.agendamento.medico.dto;

import com.agendamento.medico.model.Medico;
import com.agendamento.medico.model.Paciente;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgendarConsultaRequestDTO {

    @NotBlank
    @JsonProperty("dataHoraConsulta")
    private String dataHoraConsulta;

    @NotNull
    private MedicoDTO medico;

    @NotNull
    private PacienteDTO paciente;

}
