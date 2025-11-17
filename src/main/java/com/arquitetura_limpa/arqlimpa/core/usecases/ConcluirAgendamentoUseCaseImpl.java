package com.arquitetura_limpa.arqlimpa.core.usecases;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;
import com.arquitetura_limpa.arqlimpa.core.gateway.AgendamentoGateway;

public class ConcluirAgendamentoUseCaseImpl implements ConcluirAgendamentoUseCase{


    private final AgendamentoGateway agendamentoGateway;

    public ConcluirAgendamentoUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public Agendamento execute(Long id) {
        if (agendamentoGateway.cancelarAgendamento(id) == null){
            throw new IllegalArgumentException("Agendamento não encontrado");
        }
        return agendamentoGateway.concluirAgendamento(id);
    }
}
