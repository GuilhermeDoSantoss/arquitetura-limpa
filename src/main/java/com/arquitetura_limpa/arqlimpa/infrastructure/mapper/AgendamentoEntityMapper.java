package com.arquitetura_limpa.arqlimpa.infrastructure.mapper;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;
import com.arquitetura_limpa.arqlimpa.core.enums.StatusAgendamento;
import com.arquitetura_limpa.arqlimpa.infrastructure.persistence.AgendamentoEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AgendamentoEntityMapper {

    public AgendamentoEntity toEntity(Agendamento agendamento){
        return AgendamentoEntity.builder()
                .titulo(agendamento.titulo())
                .descricao(agendamento.descricao())
                .dataInicio(agendamento.dataInicio())
                .dataFim(agendamento.dataFim())
                .usuario(agendamento.usuario())
                .status(StatusAgendamento.AGENDADO)
                .criadoEm(LocalDateTime.now())
                .atualizadoEm(LocalDateTime.now())
                .build();
    }

    public Agendamento toDomain(AgendamentoEntity agendamentoEntity){
        return new Agendamento(
                agendamentoEntity.getId(),
                agendamentoEntity.getTitulo(),
                agendamentoEntity.getDescricao(),
                agendamentoEntity.getDataInicio(),
                agendamentoEntity.getDataFim(),
                agendamentoEntity.getStatus(),
                agendamentoEntity.getUsuario(),
                agendamentoEntity.getCriadoEm(),
                agendamentoEntity.getAtualizadoEm()
        );
    }

}
