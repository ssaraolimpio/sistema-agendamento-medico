package com.github.ssaraolimpio.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Table(name = "medico", catalog = "dbconsultorio", schema = "")
public class Medico implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "idMedico")
    private Long id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "crm")
    private String crm;

    @NotBlank
    @Column(name = "especialidade")
    private String especialidade;

    @ElementCollection
    @Column(name = "escalaAtendimento")
    private List<LocalTime> horariosAtendimento;

}
