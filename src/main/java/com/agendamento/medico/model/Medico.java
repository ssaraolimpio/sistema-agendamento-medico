package com.agendamento.medico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String crm;

    @NotBlank
    private String especialidade;

    @ElementCollection
    private List<LocalTime> horariosAtendimento;

}
