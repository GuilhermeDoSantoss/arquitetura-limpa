package com.arquitetura_limpa.arqlimpa.infrastructure.presentation;

import com.arquitetura_limpa.arqlimpa.core.entities.Agendamento;
import com.arquitetura_limpa.arqlimpa.core.usecases.*;
import com.arquitetura_limpa.arqlimpa.infrastructure.dto.AgendamentoCreateRequest;
import com.arquitetura_limpa.arqlimpa.infrastructure.dto.AgendamentoResponse;
import com.arquitetura_limpa.arqlimpa.infrastructure.dto.AgendamentoUpdateRequest;
import com.arquitetura_limpa.arqlimpa.infrastructure.mapper.AgendamentoCreateMapper;
import com.arquitetura_limpa.arqlimpa.infrastructure.mapper.AgendamentoResponseMapper;
import com.arquitetura_limpa.arqlimpa.infrastructure.mapper.AgendamentoUpadateRequestMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/agendamentos")
public class AgendamentoController {

    private final CriarAgendamentoUseCase criarAgendamentoUseCase;
    private final BuscarAgendamentoPorIdUseCase buscarAgendamentoPorIdUseCase;
    private final AtualizarAgendamentoUseCase atualizarAgendamentoUseCase;
    private final CancelarAgendamentoUseCase cancelarAgendamentoUseCase;
    private final ConcluirAgendamentoUseCase concluirAgendamentoUseCase;
    private final AgendamentoCreateMapper agendamentoCreateMapper;
    private final AgendamentoResponseMapper agendamentoResponseMapper;
    private final AgendamentoUpadateRequestMapper agendamentoUpadateRequestMapper;

    public AgendamentoController(CriarAgendamentoUseCase criarAgendamentoUseCase, BuscarAgendamentoPorIdUseCase buscarAgendamentoPorIdUseCase, AtualizarAgendamentoUseCase atualizarAgendamentoUseCase, CancelarAgendamentoUseCase cancelarAgendamentoUseCase, ConcluirAgendamentoUseCase concluirAgendamentoUseCase, AgendamentoCreateMapper agendamentoCreateMapper, AgendamentoResponseMapper agendamentoResponseMapper, AgendamentoUpadateRequestMapper agendamentoUpadateRequestMapper) {
        this.criarAgendamentoUseCase = criarAgendamentoUseCase;
        this.buscarAgendamentoPorIdUseCase = buscarAgendamentoPorIdUseCase;
        this.atualizarAgendamentoUseCase = atualizarAgendamentoUseCase;
        this.cancelarAgendamentoUseCase = cancelarAgendamentoUseCase;
        this.concluirAgendamentoUseCase = concluirAgendamentoUseCase;
        this.agendamentoCreateMapper = agendamentoCreateMapper;
        this.agendamentoResponseMapper = agendamentoResponseMapper;
        this.agendamentoUpadateRequestMapper = agendamentoUpadateRequestMapper;
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> criarAgendamento(AgendamentoCreateRequest request){
        Agendamento criado = criarAgendamentoUseCase.execute(agendamentoCreateMapper.toEntity(request));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Agendamento criado com sucesso");
        response.put("Agendamento", agendamentoResponseMapper.toDto(criado));
        return ResponseEntity.ok(response);
    }

    @GetMapping({"/id"})
    public ResponseEntity<AgendamentoResponse> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(agendamentoResponseMapper.toDto(buscarAgendamentoPorIdUseCase.execute(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizarAgendamento(@PathVariable Long id, @RequestBody AgendamentoUpdateRequest request){
        Agendamento existente = buscarAgendamentoPorIdUseCase.execute(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        Agendamento atualizado = atualizarAgendamentoUseCase.execute(agendamentoUpadateRequestMapper.merge(existente));
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Agendamento atualizado com sucesso");
        response.put("agendamento", agendamentoResponseMapper.toDto(atualizado));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<Map<String, Object>> cancelarAgendamento(@PathVariable Long id){
        Agendamento existente = buscarAgendamentoPorIdUseCase.execute(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }
        Agendamento cancelado = cancelarAgendamentoUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Agendamento cancelado com sucesso");
        response.put("agendamento", agendamentoResponseMapper.toDto(cancelado));
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/concluir")
    public ResponseEntity<Map<String, Object>> concluirAgendamento(@PathVariable Long id){
        Agendamento existente = buscarAgendamentoPorIdUseCase.execute(id);
        if (existente == null){
            return ResponseEntity.notFound().build();
        }
        Agendamento concluido = concluirAgendamentoUseCase.execute(id);
        Map<String, Object> response = new HashMap<>();
        response.put("mensagem", "Agendamento cancelado com sucesso");
        response.put("agendamento", agendamentoResponseMapper.toDto(concluido));
        return ResponseEntity.ok(response);
    }



}
