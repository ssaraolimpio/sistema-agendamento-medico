package com.agendamento.medico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "tb.medicos")
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMedico")
    private Long id;

    @NotBlank
    @Column(name = "nomeMedico")
    private String nomeMedico;

    @NotBlank
    @Column(name = "crm")
    private String crm;

    @NotBlank
    @Column(name = "especialidade")
    private String especialidade;

    @ElementCollection
    @Column(name = "agenda")
    private List<LocalTime> agenda;

}
