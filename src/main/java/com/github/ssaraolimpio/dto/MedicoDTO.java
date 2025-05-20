package com.github.ssaraolimpio.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Data
public class MedicoDTO {

    @Id
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
