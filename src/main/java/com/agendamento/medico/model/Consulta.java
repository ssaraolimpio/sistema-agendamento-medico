package com.agendamento.medico.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Data
@Table(name = "tb.consultas")
public class Consulta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idConsulta")
    private Long id;

    @NotBlank
    @Column(name = "dataHoraConsulta")
    private String dataHoraConsulta;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idMedico", nullable = false)
    private Medico medico;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;


}
