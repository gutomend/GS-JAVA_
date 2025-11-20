package com.gsolution.saudemental.api.controller;


import com.gsolution.saudemental.api.domain.dto.RegistroDiarioRequestDTO;
import com.gsolution.saudemental.api.domain.dto.RegistroDiarioRequestDTO.*;
import com.gsolution.saudemental.api.domain.dto.RegistroDiarioResponseDTO;
import com.gsolution.saudemental.api.domain.model.Paciente;
import com.gsolution.saudemental.api.domain.service.*;
import com.gsolution.saudemental.api.mapper.RegistroDiarioMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros-diarios")
public class RegistroDiarioController {

    private final RegistroDiarioService service;
    private final PacienteService pacienteService;
    private final RegistroDiarioMapper mapper;

    public RegistroDiarioController(RegistroDiarioService service, PacienteService pacienteService, RegistroDiarioMapper mapper) {
        this.service = service;
        this.pacienteService = pacienteService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<RegistroDiarioResponseDTO> listar() {
        return service.listar().stream().map(mapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public RegistroDiarioResponseDTO buscar(@PathVariable Long id) {
        return mapper.toDTO(service.buscar(id));
    }

    @PostMapping
    public RegistroDiarioResponseDTO criar(@Valid @RequestBody RegistroDiarioRequestDTO dto) {
        Paciente paciente = pacienteService.buscar(dto.pacienteId());
        var registro = mapper.toEntity(dto, paciente);
        return mapper.toDTO(service.salvar(registro));
    }

    @PutMapping("/{id}")
    public RegistroDiarioResponseDTO atualizar(
            @PathVariable Long id,
            @Valid @RequestBody RegistroDiarioRequestDTO dto
    ) {
        Paciente paciente = pacienteService.buscar(dto.pacienteId());
        var registro = mapper.toEntity(dto, paciente);
        return mapper.toDTO(service.atualizar(id, registro));
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        service.remover(id);
    }
}
