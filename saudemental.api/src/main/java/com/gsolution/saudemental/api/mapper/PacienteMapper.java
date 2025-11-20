package com.gsolution.saudemental.api.mapper;

import com.gsolution.saudemental.api.domain.dto.PacienteRequestDTO;
import com.gsolution.saudemental.api.domain.dto.PacienteRequestDTO.*;
import com.gsolution.saudemental.api.domain.dto.PacienteResponseDTO;
import com.gsolution.saudemental.api.domain.model.Paciente;
import org.springframework.stereotype.Component;

@Component
public class PacienteMapper {

    public Paciente toEntity(PacienteRequestDTO dto) {
        return Paciente.builder()
                .nome(dto.nome())
                .email(dto.email())
                .dataNascimento(dto.dataNascimento())
                .build();
    }

    public PacienteResponseDTO toDTO(Paciente paciente) {
        return new PacienteResponseDTO(
                paciente.getId(),
                paciente.getNome(),
                paciente.getEmail(),
                paciente.getDataNascimento()
        );
    }
}
