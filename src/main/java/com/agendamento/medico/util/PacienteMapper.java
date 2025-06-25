package com.agendamento.medico.util;

import com.agendamento.medico.dto.PacienteDTO;
import com.agendamento.medico.model.Paciente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapper {
    Paciente toEntity(PacienteDTO dto);
}
