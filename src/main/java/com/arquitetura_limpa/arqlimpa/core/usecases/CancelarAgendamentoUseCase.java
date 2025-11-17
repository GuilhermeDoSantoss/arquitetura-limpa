package com.arquitetura_limpa.arqlimpa.core.usecases;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;

public interface CancelarAgendamentoUseCase {

    Agendamento execute(Long id);
}
