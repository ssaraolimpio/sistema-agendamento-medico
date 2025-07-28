package com.agendamento.medico.validation;

import com.agendamento.medico.model.Consulta;
import com.agendamento.medico.model.Medico;
import com.agendamento.medico.model.Paciente;
import com.agendamento.medico.repository.ConsultaRepository;
import com.agendamento.medico.repository.MedicoRepository;
import com.agendamento.medico.repository.PacienteRepository;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
public class ValidaDadosConsulta {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    public ValidaDadosConsulta(ConsultaRepository consultaRepository, MedicoRepository medicoRepository, PacienteRepository pacienteRepository) {
        this.consultaRepository = consultaRepository;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    /*
    Valida a hora que a consulta está sendo agendada
     */
    public void validaDataAgendamento(Consulta consulta) throws Exception {
        LocalDateTime dataHoraConsulta = LocalDateTime.parse(consulta.getDataHoraConsulta());
        if (dataHoraConsulta.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("A data e hora da consulta não pode ser no passado.");
        }
        int hora = dataHoraConsulta.getHour();
        if (hora < 8 || hora >= 18) {
            throw new IllegalArgumentException("A consulta deve ser agendada entre às 08:00 e 18:00.");
        }
    }

    /*
    Valida se o paciente está cadastrado no sistema.
     */
    public void validaPaciente(Consulta consulta){
        Paciente paciente = pacienteRepository.findByCpf(consulta.getPaciente().getCpf())
                .orElseThrow(() -> new IllegalArgumentException("Paciente não possui cadastro."));
    }

    /*
    Valida se o médico está cadastrado no sistema.
     */
    public void validaMedico(Consulta consulta) {
        Medico medico = medicoRepository.findByCrm(consulta.getMedico().getCrm())
                .orElseThrow(() -> new IllegalArgumentException("Médico não possui cadastro."));
    }

    /*
     Valida se o médico está com horário selecionado disponível.
    */
    public boolean validaDisponibilidadeMedico(Consulta consulta){
        return !consultaRepository.existsByMedicoIdAndDataHoraConsulta(consulta.getMedico().getId(), consulta.getDataHoraConsulta());

    }

}
