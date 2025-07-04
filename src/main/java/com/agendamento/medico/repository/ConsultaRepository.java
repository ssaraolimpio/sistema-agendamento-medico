package com.agendamento.medico.repository;

import com.agendamento.medico.model.Consulta;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    default Consulta findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() ->
                new EntityNotFoundException("Consulta com ID " + id + " não encontrada."));
    }

    boolean existsByMedicoIdAndDataHoraConsulta(Long medicoId, String dataHora);
}

