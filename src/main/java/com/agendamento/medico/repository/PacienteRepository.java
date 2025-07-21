package com.agendamento.medico.repository;

import java.util.Optional;
import com.agendamento.medico.model.Paciente;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Optional<Paciente> findByCpf(String cpf);

    boolean existsByCpf(String cpf);

    default Paciente findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(() ->
                new EntityNotFoundException("Paciente com ID " + id + " não encontrado."));
    }
}

