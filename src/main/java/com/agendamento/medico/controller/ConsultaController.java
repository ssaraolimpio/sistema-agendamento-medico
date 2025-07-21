package com.agendamento.medico.controller;

import com.agendamento.medico.dto.AgendarConsultaRequestDTO;
import com.agendamento.medico.dto.AgendarConsultaResponseDTO;
import com.agendamento.medico.dto.CancelarConsultaRequestDTO;
import com.agendamento.medico.model.Consulta;
import com.agendamento.medico.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @PostMapping("/agendar")
    public ResponseEntity<AgendarConsultaResponseDTO> agendarConsulta(@RequestBody @Valid AgendarConsultaRequestDTO consultaDTO) throws Exception {

        AgendarConsultaResponseDTO response = service.agendarConsulta(consultaDTO);

        return ResponseEntity.ok(response);
    }

    /*
    @DeleteMapping("/cancelar")
    public ResponseEntity<CancelarConsultaRequestDTO> cancelarConsulta(@RequestBody @Valid CancelarConsultaRequestDTO cancelar){

        consulta = service.cancelarConsulta(cancelar);
        CancelarConsultaRequestDTO response = new CancelarConsultaRequestDTO(consulta);

        return ResponseEntity.ok(response);

    }*/

}
