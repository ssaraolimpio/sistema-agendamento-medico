package com.github.ssaraolimpio.service;

import com.github.ssaraolimpio.dto.ConsultaDTO;
import com.github.ssaraolimpio.model.Consulta;
import com.github.ssaraolimpio.repository.ConsultaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@Slf4j
public abstract class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository repository;

    protected ConsultaServiceImpl(ConsultaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Consulta agendarConsulta(ConsultaDTO consultaDTO) {

        // convertendo DTO para model
        Consulta consulta = new Consulta(consultaDTO);

        /* TODO: criar métodos que validam regras de negócio
         *   1. agendamento não pode ser data retroativa ✅
         *   2. a consulta deve estar dentro do horário de atendimento do médico
         *   3. médico só pode atender 1 paciente por vez (1:1)
         * */

        try {
            String data = consulta.getData();
            String hora = consulta.getHora();

            LocalDateTime dataHoraAgendada = LocalDateTime.parse(data + "T" + hora);

            this.validaDataAgendamento(dataHoraAgendada);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao validar data/hora da consulta",e);
        }

        return repository.save(consulta);
    }

    public void validaDataAgendamento(LocalDateTime dataHoraAgendada) throws Exception {
        try {
            if (dataHoraAgendada.isBefore(LocalDateTime.now())) {
                throw new IllegalArgumentException("A data e hora da consulta não pode ser no passado.");
            }

            int hora = dataHoraAgendada.getHour();
            if (hora < 8 || hora >= 18) {
                throw new IllegalArgumentException("A consulta deve ser entre às 08:00 e 18:00.");
            }
        } catch (Exception e) {
            log.error("Erro ao validar data/hora da consulta.");
            throw new RuntimeException("Erro ao validar data/hora da consulta",e);
        }
    }

}
