package com.agendamento.medico.controller;

import com.agendamento.medico.dto.ConsultaDTO;
import com.agendamento.medico.model.Consulta;
import com.agendamento.medico.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private Consulta consulta;

    @Autowired
    private ConsultaService service;

    @PostMapping("/agendar")
    public ResponseEntity<ConsultaDTO> agendarConsulta(@RequestBody @Valid ConsultaDTO consultaDTO){

        consulta = service.agendarConsulta(consultaDTO);
        ConsultaDTO response = new ConsultaDTO(consulta);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/cancelar")
    public ResponseEntity<ConsultaDTO> cancelarConsulta(@RequestBody @Valid ConsultaDTO consultaDTO){

        consulta = service.cancelarConsulta(consultaDTO);
        ConsultaDTO response = new ConsultaDTO(consulta);

        return ResponseEntity.ok(response);

    }

}
