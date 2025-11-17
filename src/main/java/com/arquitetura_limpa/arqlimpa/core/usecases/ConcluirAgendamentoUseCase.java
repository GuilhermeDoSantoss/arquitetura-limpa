package com.arquitetura_limpa.arqlimpa.core.usecases;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;

public interface ConcluirAgendamentoUseCase {

    Agendamento execute(Long id);
}
