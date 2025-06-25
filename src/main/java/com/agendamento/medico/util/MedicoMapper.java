package com.agendamento.medico.util;

import com.agendamento.medico.dto.MedicoDTO;
import com.agendamento.medico.model.Medico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MedicoMapper {
    Medico toEntity(MedicoDTO dto);
}
