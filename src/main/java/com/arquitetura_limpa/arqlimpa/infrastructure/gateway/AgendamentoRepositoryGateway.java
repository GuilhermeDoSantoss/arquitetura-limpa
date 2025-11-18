package com.arquitetura_limpa.arqlimpa.infrastructure.gateway;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;
import com.arquitetura_limpa.arqlimpa.core.enums.StatusAgendamento;
import com.arquitetura_limpa.arqlimpa.core.gateway.AgendamentoGateway;
import com.arquitetura_limpa.arqlimpa.infrastructure.mapper.AgendamentoEntityMapper;
import com.arquitetura_limpa.arqlimpa.infrastructure.persistence.AgendamentoEntity;
import com.arquitetura_limpa.arqlimpa.infrastructure.persistence.AgendamentoRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AgendamentoRepositoryGateway implements AgendamentoGateway {

    private final AgendamentoRepository repository;
    private final AgendamentoEntityMapper entityMapper;

    public AgendamentoRepositoryGateway(AgendamentoRepository repository, AgendamentoEntityMapper entityMapper) {
        this.repository = repository;
        this.entityMapper = entityMapper;
    }


    @Override
    public Agendamento criarAgendamento(Agendamento agendamento) {

        validarIntervalo(agendamento.dataInicio(), agendamento.dataFim());
        checarConflito(agendamento.usuario(), agendamento.dataInicio(), agendamento.dataFim(), agendamento.id());
        AgendamentoEntity entity = repository.save(entityMapper.toEntity(agendamento));
        return entityMapper.toDomain(entity);
    }

    @Override
    public Agendamento buscarAgendamentoPorId(Long id) {
        return repository.findById(id)
                .map(entityMapper::toDomain)
                .orElse(null);
    }

    @Override
    public Agendamento atualizarAgendamento(Agendamento agendamento) {
        return entityMapper.toDomain(repository.save(entityMapper.toEntity(agendamento)));
    }

    @Override
    public Agendamento cancelarAgendamento(Long id) {
        var existente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
        existente.setStatus(StatusAgendamento.CANCELADO);
        existente.setAtualizadoEm(LocalDateTime.now());
        return entityMapper.toDomain(repository.save(existente));
    }

    @Override
    public Agendamento concluirAgendamento(Long id) {
        var existente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agendamento não encontrado"));
        existente.setStatus(StatusAgendamento.CONCLUIDO);
        existente.setAtualizadoEm(LocalDateTime.now());
        return entityMapper.toDomain(repository.save(existente));
    }

    private void validarIntervalo(LocalDateTime inicio, LocalDateTime fim){
        if(inicio == null || fim == null || !inicio.isBefore(fim)){
            throw new IllegalArgumentException("Intervalo inválido");
        }
    }

    private void checarConflito(String usuario, LocalDateTime inicio, LocalDateTime fim, Long ignoreId){
        boolean conflito = repository.existsConflito(usuario, inicio, fim, ignoreId);
        if (conflito) {
            throw new IllegalArgumentException("Conflito de agenda");
        }
    }
}
