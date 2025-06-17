package com.github.ssaraolimpio.repository;

import com.github.ssaraolimpio.model.Consulta;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    default Consulta findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() ->
                new EntityNotFoundException("Consulta com ID " + id + " não encontrada."));
    }

    boolean existsByIdMedicoAndDataHora(Long idMedico, String dataHora);
}

