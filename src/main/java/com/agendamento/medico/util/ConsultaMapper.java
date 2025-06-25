package com.agendamento.medico.util;

import com.agendamento.medico.dto.AgendarConsultaRequestDTO;
import com.agendamento.medico.dto.AgendarConsultaResponseDTO;
import com.agendamento.medico.model.Consulta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring", uses = {MedicoMapper.class, PacienteMapper.class})
public interface ConsultaMapper {

    @Mapping(target = "dataHoraConsulta", source = "dataHoraConsulta")
    @Mapping(target = "medico", source = "medico")
    @Mapping(target = "paciente", source = "paciente")
    public Consulta toEntity(AgendarConsultaRequestDTO dto);

    @Mapping(target = "idConsulta", source = "id")
    @Mapping(target = "dataHoraConsulta", source = "dataHoraConsulta")
    @Mapping(target = "nomePaciente", source = "paciente.nomePaciente")
    @Mapping(target = "cpf", source = "paciente.cpf")
    @Mapping(target = "nomeMedico", source = "medico.nomeMedico")
    @Mapping(target = "especialidade", source = "medico.especialidade")
    public AgendarConsultaResponseDTO toResponseDTO(Consulta consulta);



}
