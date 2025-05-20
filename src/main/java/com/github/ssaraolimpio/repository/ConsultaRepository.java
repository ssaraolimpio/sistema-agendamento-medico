package com.github.ssaraolimpio.repository;

import com.github.ssaraolimpio.model.Consulta;
import com.github.ssaraolimpio.model.Medico;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    default Consulta findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() ->
                new EntityNotFoundException("Consulta com ID " + id + " não encontrada."));
    }
}

