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

    // todo: revisar linha 16 e 17
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Consulta c WHERE c.medico.id = :medicoId AND c.horario = :horario")
    boolean existsByMedicoAndHorario(Long medicoId, LocalDateTime horario);

    default Consulta findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() ->
                new EntityNotFoundException("Consulta com ID " + id + " não encontrada."));
    }
}

