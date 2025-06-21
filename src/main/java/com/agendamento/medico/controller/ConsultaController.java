package com.agendamento.medico.controller;

import com.agendamento.medico.dto.ConsultaRequestDTO;
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
    public ResponseEntity<ConsultaRequestDTO> agendarConsulta(@RequestBody @Valid ConsultaRequestDTO consultaDTO){

        // todo: preciso receber uma requisição com as seguintes informações ->
        /*
        idConsulta
        dataHora
        nomeMedico
        especialidadeMedico
        nomePaciente
         */

        consulta = service.agendarConsulta(consultaDTO);
        ConsultaRequestDTO response = new ConsultaRequestDTO(consulta);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/cancelar")
    public ResponseEntity<ConsultaRequestDTO> cancelarConsulta(@RequestBody @Valid ConsultaRequestDTO consultaDTO){

        consulta = service.cancelarConsulta(consultaDTO);
        ConsultaRequestDTO response = new ConsultaRequestDTO(consulta);

        return ResponseEntity.ok(response);

    }

}
