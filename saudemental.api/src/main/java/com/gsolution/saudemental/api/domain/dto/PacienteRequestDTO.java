package com.gsolution.saudemental.api.domain.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record PacienteRequestDTO(
        @NotBlank String nome,
        @Email @NotBlank String email,
        @Past LocalDate dataNascimento
) {}