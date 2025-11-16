package com.arquitetura_limpa.arqlimpa.core.gateway;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;

public interface AgendamentoGateway {

    Agendamento criarAgendamento(Agendamento agendamento);
    Agendamento buscarAgendamentoPorId(Long id);
    Agendamento atualizarAgendamento(Agendamento agendamento);
    Agendamento cancelarAgendamento(Long id);
    Agendamento concluirAgendamento(Long id);
}
