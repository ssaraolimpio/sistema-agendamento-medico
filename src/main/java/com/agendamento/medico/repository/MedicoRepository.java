package com.agendamento.medico.repository;

import com.agendamento.medico.model.Medico;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    boolean existsByCrm(String crm);

    default Medico findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() ->
                new EntityNotFoundException("Médico com ID " + id + " não encontrado."));
    }

}
