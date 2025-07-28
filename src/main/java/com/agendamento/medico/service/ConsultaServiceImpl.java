package com.agendamento.medico.service;

import com.agendamento.medico.dto.AgendarConsultaRequestDTO;
import com.agendamento.medico.dto.AgendarConsultaResponseDTO;
import com.agendamento.medico.model.Consulta;
import com.agendamento.medico.repository.ConsultaRepository;
import com.agendamento.medico.util.ConsultaMapper;
import com.agendamento.medico.validation.ValidaDadosConsulta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final ConsultaMapper mapper;
    private final ValidaDadosConsulta validaDadosConsulta;

    public ConsultaServiceImpl(ConsultaRepository consultaRepository,
                               ConsultaMapper mapper,
                               ValidaDadosConsulta validaDadosConsulta) {
        this.consultaRepository = consultaRepository;
        this.mapper = mapper;
        this.validaDadosConsulta = validaDadosConsulta;
    }

    @Override
    public AgendarConsultaResponseDTO agendarConsulta(AgendarConsultaRequestDTO consultaDTO) throws Exception {

        Consulta consulta = mapper.toEntity(consultaDTO);
        AgendarConsultaResponseDTO response = new AgendarConsultaResponseDTO();

            validaDadosConsulta.validaDataAgendamento(consulta);
            validaDadosConsulta.validaPaciente(consulta);
            validaDadosConsulta.validaMedico(consulta);

            // Se o médico já tiver uma consulta marcada nesse horário, lança uma exceção
            if (!validaDadosConsulta.validaDisponibilidadeMedico(consulta)) {
                throw new IllegalArgumentException("O médico já tem uma consulta marcada nesse horário.");
            } else {

                // Se o paciente e o médico estiverem cadastrados + horário disponível, prossegue com o agendamento da consulta
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
