package com.agendamento.medico.service;

import com.agendamento.medico.dto.ConsultaDTO;
import com.agendamento.medico.model.Consulta;
import com.agendamento.medico.repository.ConsultaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Slf4j
@Service
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;

    public ConsultaServiceImpl(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    @Override
    public Consulta agendarConsulta(ConsultaDTO consultaDTO) {

        // convertendo DTO para model
        Consulta consulta = new Consulta(consultaDTO);

        try {
            // valida data e hora do agendamento da consutla
            LocalDateTime dataHoraConsulta = LocalDateTime.parse(consulta.getDataHora());
            this.validaDataAgendamento(dataHoraConsulta);

            // verifica disponibilidade do médico e horario na base de dados
            boolean indisponivel = consultaRepository.existsByIdMedicoAndDataHora(consulta.getIdMedico(), consulta.getDataHora());
            if (indisponivel){
                throw new IllegalArgumentException("O médico já tem uma consulta marcada nesse horário.");
            }
            // todo: se disponivel, entao agendar consulta
            consulta.setId(consultaDTO.getId());
            consulta.setIdMedico(consultaDTO.getIdMedico());
            consulta.setIdPaciente(consultaDTO.getIdPaciente());
            consulta.setDataHora(consultaDTO.getDataHora());

            consultaRepository.save(consulta);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao validar data/hora da consulta",e);
        }

        return consultaRepository.save(consulta);
    }

    public void validaDataAgendamento(LocalDateTime dataHoraConsulta) throws Exception {

        try {
            if (dataHoraConsulta.isBefore(LocalDateTime.now())) {
                throw new IllegalArgumentException("A data e hora da consulta não pode ser no passado.");
            }

            int hora = dataHoraConsulta.getHour();
            if (hora < 8 || hora >= 18) {
                throw new IllegalArgumentException("A consulta deve ser entre às 08:00 e 18:00.");
            }
        } catch (Exception e) {
            log.error("Erro ao validar data/hora da consulta.");
            throw new RuntimeException("Erro ao validar data/hora da consulta",e);
        }
    }

}
