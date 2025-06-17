package com.agendamento.medico.service;

import com.agendamento.medico.dto.ConsultaDTO;
import com.agendamento.medico.model.Consulta;

public interface ConsultaService {

    public Consulta agendarConsulta(ConsultaDTO consultaDTO);

}
