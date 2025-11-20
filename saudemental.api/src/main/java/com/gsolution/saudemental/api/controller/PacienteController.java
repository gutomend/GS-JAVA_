package com.gsolution.saudemental.api.controller;


import com.gsolution.saudemental.api.domain.dto.PacienteRequestDTO;
import com.gsolution.saudemental.api.domain.dto.PacienteRequestDTO.*;
import com.gsolution.saudemental.api.domain.dto.PacienteResponseDTO;
import com.gsolution.saudemental.api.domain.service.PacienteService;
import com.gsolution.saudemental.api.mapper.PacienteMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;
    private final PacienteMapper mapper;

    public PacienteController(PacienteService service, PacienteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<PacienteResponseDTO> listar() {
        return service.listar().stream().map(mapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public PacienteResponseDTO buscar(@PathVariable Long id) {
        return mapper.toDTO(service.buscar(id));
    }

    @PostMapping
    public PacienteResponseDTO criar(@Valid @RequestBody PacienteRequestDTO dto) {
        return mapper.toDTO(service.salvar(mapper.toEntity(dto)));
    }

    @PutMapping("/{id}")
    public PacienteResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody PacienteRequestDTO dto) {
        return mapper.toDTO(service.atualizar(id, mapper.toEntity(dto)));
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}