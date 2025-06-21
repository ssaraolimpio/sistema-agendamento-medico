package com.agendamento.medico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "tb.pacientes")
public class Paciente implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaciente")
    private Long id;

    @NotBlank
    @Column(name = "nomePaciente")
    private String nomePaciente;

    @NotBlank
    @Column(name = "cpf")
    private String cpf;


}
