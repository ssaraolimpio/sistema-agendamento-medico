package com.agendamento.medico.service;

import com.agendamento.medico.dto.AgendarConsultaRequestDTO;
import com.agendamento.medico.dto.AgendarConsultaResponseDTO;
import com.agendamento.medico.model.Consulta;

public interface ConsultaService {

    public AgendarConsultaResponseDTO agendarConsulta(AgendarConsultaRequestDTO consultaDTO) throws Exception;

    public Consulta cancelarConsulta(AgendarConsultaRequestDTO consultaDTO);
}
