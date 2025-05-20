package com.github.ssaraolimpio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "consulta", catalog = "dbconsultorio", schema = "")
public class Consulta {

    @Id
    @Column(name = "idConsulta")
    private Long id;

    @NotBlank
    @Column(name = "dataConsulta")
    private String data;

    @NotBlank
    @Column(name = "horaConsulta")
    private String hora;

    @NotBlank
    @Column(name = "medico")
    private Medico medico;

    @NotBlank
    @Column(name = "paciente")
    private Paciente paciente;

}
