package com.gsolution.saudemental.api.mapper;

import com.gsolution.saudemental.api.domain.dto.RegistroDiarioRequestDTO;
import com.gsolution.saudemental.api.domain.dto.RegistroDiarioResponseDTO;
import com.gsolution.saudemental.api.domain.dto.RegistroDiarioRequestDTO.*;
import com.gsolution.saudemental.api.domain.model.*;
import org.springframework.stereotype.Component;

@Component
public class RegistroDiarioMapper {

    public RegistroDiario toEntity(RegistroDiarioRequestDTO dto, Paciente paciente) {
        return RegistroDiario.builder()
                .paciente(paciente)
                .dataRegistro(dto.dataRegistro())
                .nivelHumor(dto.nivelHumor())
                .nivelAnsiedade(dto.nivelAnsiedade())
                .horasSono(dto.horasSono())
                .build();
    }

    public RegistroDiarioResponseDTO toDTO(RegistroDiario r) {
        return new RegistroDiarioResponseDTO(
                r.getId(),
                r.getPaciente().getId(),
                r.getDataRegistro(),
                r.getNivelHumor(),
                r.getNivelAnsiedade(),
                r.getHorasSono()
        );
    }
}
