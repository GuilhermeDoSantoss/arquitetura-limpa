package com.arquitetura_limpa.arqlimpa.infrastructure.beans;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;
import com.arquitetura_limpa.arqlimpa.core.gateway.AgendamentoGateway;
import com.arquitetura_limpa.arqlimpa.core.usecases.*;
import com.arquitetura_limpa.arqlimpa.infrastructure.gateway.AgendamentoRepositoryGateway;
import com.arquitetura_limpa.arqlimpa.infrastructure.mapper.AgendamentoEntityMapper;
import com.arquitetura_limpa.arqlimpa.infrastructure.persistence.AgendamentoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CriarAgendamentoUseCase criarAgendamentoUseCase(AgendamentoGateway agendamentoGateway){
        return new CriarAgendamentoUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public BuscarAgendamentoPorIdUseCase buscarAgendamentoPorIdUseCase(AgendamentoGateway agendamentoGateway){
        return new BuscarAgendamentoPorIdUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public CancelarAgendamentoUseCase cancelarAgendamentoUseCase(AgendamentoGateway agendamentoGateway){
        return new CancelarAgendamentoUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public ConcluirAgendamentoUseCase concluirAgendamentoUseCase(AgendamentoGateway agendamentoGateway){
        return new ConcluirAgendamentoUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public AtualizarAgendamentoUseCase atualizarAgendamentoUseCase(AgendamentoGateway agendamentoGateway){
        return new AtualizarAgendamentoUseCaseImpl(agendamentoGateway);
    }

    @Bean
    public AgendamentoGateway agendamentoGateway(
            AgendamentoRepository repository,
            AgendamentoEntityMapper mapper
    ) {
        return new AgendamentoRepositoryGateway(repository, mapper);
    }



}
