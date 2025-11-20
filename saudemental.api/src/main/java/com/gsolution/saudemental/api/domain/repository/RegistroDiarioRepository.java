package com.gsolution.saudemental.api.domain.repository;

import com.gsolution.saudemental.api.domain.model.RegistroDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RegistroDiarioRepository extends JpaRepository<RegistroDiario, Long> {

    List<RegistroDiario> findByPacienteId(Long pacienteId);

    List<RegistroDiario> findByDataRegistroBetween(LocalDate inicio, LocalDate fim);

    boolean existsByPacienteIdAndDataRegistro(Long pacienteId, LocalDate data);
}
