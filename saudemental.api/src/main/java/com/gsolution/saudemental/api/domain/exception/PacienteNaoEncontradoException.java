package com.gsolution.saudemental.api.domain.exception;

public class PacienteNaoEncontradoException extends RuntimeException {

    public PacienteNaoEncontradoException(Long id) {
        super("Paciente não encontrado. ID: " + id);
    }
}
