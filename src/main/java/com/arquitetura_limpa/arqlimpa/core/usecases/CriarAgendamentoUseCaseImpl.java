package com.arquitetura_limpa.arqlimpa.core.usecases;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;
import com.arquitetura_limpa.arqlimpa.core.gateway.AgendamentoGateway;

public class CriarAgendamentoUseCaseImpl implements CriarAgendamentoUseCase{

    private final AgendamentoGateway agendamentoGateway;

    public CriarAgendamentoUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public Agendamento execute(Agendamento agendamento) {
        return agendamentoGateway.criarAgendamento(agendamento);
    }
}
