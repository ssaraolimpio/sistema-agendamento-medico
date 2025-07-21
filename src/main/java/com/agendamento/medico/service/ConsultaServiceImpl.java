package com.agendamento.medico.service;

import com.agendamento.medico.dto.AgendarConsultaRequestDTO;
import com.agendamento.medico.dto.AgendarConsultaResponseDTO;
import com.agendamento.medico.model.Consulta;
import com.agendamento.medico.model.Medico;
import com.agendamento.medico.model.Paciente;
import com.agendamento.medico.repository.ConsultaRepository;
import com.agendamento.medico.repository.MedicoRepository;
import com.agendamento.medico.repository.PacienteRepository;
import com.agendamento.medico.util.ConsultaMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;


@Slf4j
@Service
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;
    private final ConsultaMapper mapper;

    public ConsultaServiceImpl(ConsultaRepository consultaRepository, MedicoRepository medicoRepository, PacienteRepository pacienteRepository, ConsultaMapper mapper) {
        this.consultaRepository = consultaRepository;
        this.mapper = mapper;
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public AgendarConsultaResponseDTO agendarConsulta(AgendarConsultaRequestDTO consultaDTO) throws Exception {

        Consulta consulta = mapper.toEntity(consultaDTO);
        AgendarConsultaResponseDTO response = new AgendarConsultaResponseDTO();

            LocalDateTime dataHoraConsulta = LocalDateTime.parse(consulta.getDataHoraConsulta());
            this.validaDataAgendamento(dataHoraConsulta);

            Paciente paciente = pacienteRepository.findByCpf(consulta.getPaciente().getCpf())
                    .orElseThrow(() -> new IllegalArgumentException("Paciente não possui cadastro."));

            Medico medico = medicoRepository.findByCrm(consulta.getMedico().getCrm())
                    .orElseThrow(() -> new IllegalArgumentException("Médico não possui cadastro."));

            boolean isIndisponivel = consultaRepository.existsByMedicoIdAndDataHoraConsulta(consulta.getMedico().getId(), consulta.getDataHoraConsulta());

            if (isIndisponivel) {
                throw new IllegalArgumentException("O médico já tem uma consulta marcada nesse horário.");
            } else {

                response.setIdConsulta(consulta.getId());
                response.setDataHoraConsulta(consulta.getDataHoraConsulta());
                response.setNomePaciente(consulta.getPaciente().getNomePaciente());
                response.setCpf(consulta.getPaciente().getCpf());
                response.setNomeMedico(consulta.getMedico().getNomeMedico());
                response.setEspecialidade(consulta.getMedico().getEspecialidade());

                Consulta consultaAgendada = consultaRepository.save(consulta);

                return mapper.toResponseDTO(consultaAgendada);
            }
    }


    public void validaDataAgendamento(LocalDateTime dataHoraConsulta) throws Exception {

            if (dataHoraConsulta.isBefore(LocalDateTime.now())) {
                throw new IllegalArgumentException("A data e hora da consulta não pode ser no passado.");
            }
            int hora = dataHoraConsulta.getHour();
            if (hora < 8 || hora >= 18) {
                throw new IllegalArgumentException("A consulta deve ser agendada entre às 08:00 e 18:00.");
            }
    }


    @Override
    public Consulta cancelarConsulta(AgendarConsultaRequestDTO consultaDTO) {
        Consulta consulta = new Consulta();

        try {
            //todo: buscar a consulta na base pelo id?
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //return consultaRepository.delete(consulta);
        return null;
    }

}
