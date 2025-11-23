package com.arquitetura_limpa.arqlimpa.infrastructure.mapper;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;
import com.arquitetura_limpa.arqlimpa.core.enums.StatusAgendamento;
import com.arquitetura_limpa.arqlimpa.infrastructure.dto.AgendamentoUpdateRequest;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AgendamentoUpadateRequestMapper {

    public AgendamentoUpdateRequest toDto(Agendamento agendamento){
        return new AgendamentoUpdateRequest(
                agendamento.titulo(),
                agendamento.descricao(),
                agendamento.dataInicio(),
                agendamento.dataFim()

        );
    }

    public Agendamento merge(Agendamento agendamentoExistente){
        return new Agendamento(
                agendamentoExistente.id(),
                req.titulo() != null ? req.titulo() : agendamentoExistente.titulo(),
                req.descricao() != null ? req.descricao() : agendamentoExistente.descricao(),
                req.dataInicio() != null ? req.dataInicio() : agendamentoExistente.dataInicio(),
                req.dataFim() != null ? req.dataFim() : agendamentoExistente.dataFim(),
                agendamentoExistente.status(),
                agendamentoExistente.usuario(),
                agendamentoExistente.criadoEm(),
                LocalDateTime.now()
        );
    }

    public Agendamento toEntity(AgendamentoUpdateRequest agendamentoUpdateRequest){
        return new Agendamento(
                null,
                agendamentoUpdateRequest.titulo(),
                agendamentoUpdateRequest.descricao(),
                agendamentoUpdateRequest.dataInicio(),
                agendamentoUpdateRequest.dataFim(),
                StatusAgendamento.AGENDADO,
                null,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

}
