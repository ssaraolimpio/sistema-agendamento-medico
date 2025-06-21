package com.agendamento.medico.service;

import com.agendamento.medico.dto.ConsultaRequestDTO;
import com.agendamento.medico.model.Consulta;

public interface ConsultaService {

    public Consulta agendarConsulta(ConsultaRequestDTO consultaDTO);

    public Consulta cancelarConsulta(ConsultaRequestDTO consultaDTO);
}
