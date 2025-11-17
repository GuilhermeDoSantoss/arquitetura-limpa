package com.arquitetura_limpa.arqlimpa.core.usecases;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;
import com.arquitetura_limpa.arqlimpa.core.gateway.AgendamentoGateway;

import java.time.LocalDateTime;

public class AtualizarAgendamentoUseCaseImpl implements AtualizarAgendamentoUseCase{

    private final AgendamentoGateway agendamentoGateway;

    public AtualizarAgendamentoUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public Agendamento execute(Agendamento agendamento) {
        var existente = agendamentoGateway.buscarAgendamentoPorId(agendamento.id());
        if (existente == null){
            throw new IllegalArgumentException("Agendamento não encontrado");
        }
        return agendamentoGateway.atualizarAgendamento( new Agendamento(
                existente.id(),
                agendamento.titulo(),
                agendamento.descricao(),
                agendamento.dataInicio(),
                agendamento.dataFim(),
                existente.status(),
                existente.usuario(),
                existente.criadoEm(),
                LocalDateTime.now()

        ));
    }
}
