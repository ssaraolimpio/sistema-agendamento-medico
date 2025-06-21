package com.agendamento.medico.service;

import com.agendamento.medico.dto.ConsultaRequestDTO;
import com.agendamento.medico.dto.ConsultaResponseDTO;
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
    public Consulta agendarConsulta(ConsultaRequestDTO consultaDTO) {

        Consulta consulta = new Consulta();
        ConsultaResponseDTO response = new ConsultaResponseDTO();

        try {
            LocalDateTime dataHoraConsulta = LocalDateTime.parse(consulta.getDataHoraConsulta());
            this.validaDataAgendamento(dataHoraConsulta);

            boolean isIndisponivel = consultaRepository.existsByIdMedicoAndDataHora(consulta.getMedico(), consulta.getDataHoraConsulta());

            if (isIndisponivel) {
                throw new IllegalArgumentException("O médico já tem uma consulta marcada nesse horário.");
            } else {
                consulta.setDataHoraConsulta(response.getDataHoraConsulta());
                consulta.getPaciente().setNomePaciente(response.getNomePaciente());
                consulta.getPaciente().setCpf(response.getCpf());
                consulta.getMedico().setNomeMedico(response.getNomeMedico());
                consulta.getMedico().setEspecialidade(response.getEspecialidade());

                consultaRepository.save(consulta);
            }
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


    @Override
    public Consulta cancelarConsulta(ConsultaRequestDTO consultaDTO) {
        Consulta consulta = new Consulta();

        try {
            //todo: buscar a consulta na base pelo id provavelmente e fazer um update pra cancelar
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //return consultaRepository.delete(consulta);
        return null;
    }

}
