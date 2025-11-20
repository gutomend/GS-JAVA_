package com.gsolution.saudemental.api.domain.repository;

import com.gsolution.saudemental.api.domain.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    boolean existsByEmail(String email);

    Optional<Paciente> findByEmail(String email);
}
