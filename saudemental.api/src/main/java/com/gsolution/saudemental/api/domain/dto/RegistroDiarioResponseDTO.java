package com.gsolution.saudemental.api.domain.dto;

import java.time.LocalDate;

public record RegistroDiarioResponseDTO(
        Long id,
        Long pacienteId,
        LocalDate dataRegistro,
        Integer nivelHumor,
        Integer nivelAnsiedade,
        Integer horasSono
) {}
