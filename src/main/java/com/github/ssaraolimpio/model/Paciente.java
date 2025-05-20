package com.github.ssaraolimpio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.persistence.Id;

@Entity
@Data
@Table(name = "paciente", catalog = "dbconsultorio", schema = "")
public class Paciente {

    @Id
    @Column(name = "idPaciente")
    private Long id;

    @NotBlank
    @Column(name = "nome")
    private String nome;

    @NotBlank
    @Column(name = "cpf")
    private String cpf;


}
