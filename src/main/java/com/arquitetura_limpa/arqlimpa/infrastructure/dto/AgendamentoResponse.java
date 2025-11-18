package com.arquitetura_limpa.arqlimpa.infrastructure.dto;

import com.arquitetura_limpa.arqlimpa.core.enums.StatusAgendamento;

import java.time.LocalDateTime;

public record AgendamentoResponse(
        Long id,
        String titulo,
        String descricao,
        LocalDateTime dataInicio,
        LocalDateTime dataFim,
        StatusAgendamento status,
        String usuario,
        LocalDateTime criadoEm,
        LocalDateTime atualizadoEm) {
}
