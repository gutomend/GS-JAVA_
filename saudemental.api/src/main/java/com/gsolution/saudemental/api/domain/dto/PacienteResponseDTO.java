package com.gsolution.saudemental.api.domain.dto;

import java.time.LocalDate;

public record PacienteResponseDTO(
        Long id,
        String nome,
        String email,
        LocalDate dataNascimento
) {}
