package com.github.ssaraolimpio.service;

import com.github.ssaraolimpio.dto.ConsultaDTO;
import com.github.ssaraolimpio.model.Consulta;
import org.springframework.stereotype.Service;

public interface ConsultaService {

    public Consulta agendarConsulta(ConsultaDTO consultaDTO);

}
