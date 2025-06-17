package com.agendamento.medico.model;

import com.agendamento.medico.dto.ConsultaDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String dataHora;

    @NotNull
    private Long idMedico;

    @NotNull
    private Long idPaciente;

    public Consulta(){}

    public Consulta(ConsultaDTO dto) {
        this.dataHora = dto.getDataHora();
        this.idMedico = dto.getIdMedico();
        this.idPaciente = dto.getIdPaciente();
    }

}
