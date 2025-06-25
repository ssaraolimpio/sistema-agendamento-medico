package com.agendamento.medico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CancelarConsultaRequestDTO {

    @NotNull
    private Long id;
}
