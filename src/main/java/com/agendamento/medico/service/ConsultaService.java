package com.agendamento.medico.service;

import com.agendamento.medico.dto.ConsultaDTO;
import com.agendamento.medico.model.Consulta;
import jakarta.validation.Valid;

public interface ConsultaService {

    public Consulta agendarConsulta(ConsultaDTO consultaDTO);

    public Consulta cancelarConsulta(ConsultaDTO consultaDTO);
}
