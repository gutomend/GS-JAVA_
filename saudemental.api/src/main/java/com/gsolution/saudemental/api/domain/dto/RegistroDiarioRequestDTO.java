package com.gsolution.saudemental.api.domain.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record RegistroDiarioRequestDTO(
        @NotNull Long pacienteId,
        @NotNull LocalDate dataRegistro,
        @Min(1) @Max(5) Integer nivelHumor,
        @Min(1) @Max(5) Integer nivelAnsiedade,
        @Min(0) @Max(24) Integer horasSono
) {}