package com.arquitetura_limpa.arqlimpa.core.usecases;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;
import com.arquitetura_limpa.arqlimpa.core.gateway.AgendamentoGateway;

public class BuscarAgendamentoPorIdUseCaseImpl implements BuscarAgendamentoPorIdUseCase{

    private final AgendamentoGateway agendamentoGateway;

    public BuscarAgendamentoPorIdUseCaseImpl(AgendamentoGateway agendamentoGateway) {
        this.agendamentoGateway = agendamentoGateway;
    }

    @Override
    public Agendamento execute(Long id) {

        var agendamento = agendamentoGateway.buscarAgendamentoPorId(id);
        if (agendamento == null) {
            throw new IllegalArgumentException("Agendamento não encontrado");
        }
        return agendamento;
    }
}
