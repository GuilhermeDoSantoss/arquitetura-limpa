package com.arquitetura_limpa.arqlimpa.core.usecases;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;

public interface BuscarAgendamentoPorIdUseCase {

    Agendamento execute(Long id);
}
