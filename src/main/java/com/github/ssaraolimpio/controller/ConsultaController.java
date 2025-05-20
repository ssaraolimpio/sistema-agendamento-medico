package com.github.ssaraolimpio.controller;

import com.github.ssaraolimpio.model.Consulta;
import com.github.ssaraolimpio.repository.ConsultaRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaRepository consultaRepository;
    private Consulta consulta;

    public ConsultaController(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }


}
