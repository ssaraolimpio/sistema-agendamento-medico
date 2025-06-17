package com.agendamento.medico.dto;

import com.agendamento.medico.model.Consulta;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ConsultaDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String dataHora;

    @NotNull
    private Long idMedico;

    @NotNull
    private Long idPaciente;

    public ConsultaDTO(){}

    public ConsultaDTO(Consulta consulta) {
        this.dataHora = consulta.getDataHora();
        this.idMedico = consulta.getIdMedico();
        this.idPaciente = consulta.getIdPaciente();
    }

}
