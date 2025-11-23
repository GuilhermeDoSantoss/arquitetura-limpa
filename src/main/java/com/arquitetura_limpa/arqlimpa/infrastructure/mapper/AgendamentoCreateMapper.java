package com.arquitetura_limpa.arqlimpa.infrastructure.mapper;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;
import com.arquitetura_limpa.arqlimpa.core.enums.StatusAgendamento;
import com.arquitetura_limpa.arqlimpa.infrastructure.dto.AgendamentoCreateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AgendamentoCreateMapper {

    public AgendamentoCreateRequest toDto(Agendamento agendamento){
        return new AgendamentoCreateRequest(
                agendamento.titulo(),
                agendamento.descricao(),
                agendamento.dataInicio(),
                agendamento.dataFim(),
                agendamento.usuario()
        );
    }

    public Agendamento toEntity(AgendamentoCreateRequest agendamentoCreateRequest){
        return new Agendamento(
                null,
                agendamentoCreateRequest.titulo(),
                agendamentoCreateRequest.descricao(),
                agendamentoCreateRequest.dataInicio(),
                agendamentoCreateRequest.dataFim(),
                StatusAgendamento.AGENDADO,
                agendamentoCreateRequest.usuario(),
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

}
