package com.github.ssaraolimpio.controller;

import com.github.ssaraolimpio.dto.ConsultaDTO;
import com.github.ssaraolimpio.model.Consulta;
import com.github.ssaraolimpio.repository.ConsultaRepository;
import com.github.ssaraolimpio.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaRepository consultaRepository;

    private Consulta consulta;

    @Autowired
    private ConsultaService service;

    public ConsultaController(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @PostMapping("/agendar")
    public ResponseEntity<ConsultaDTO> agendarConsulta(@RequestBody @Valid ConsultaDTO consultaDTO){

        consulta = service.agendarConsulta(consultaDTO);

        ConsultaDTO response = new ConsultaDTO(consulta);

        return ResponseEntity.ok(response);
    }

}
