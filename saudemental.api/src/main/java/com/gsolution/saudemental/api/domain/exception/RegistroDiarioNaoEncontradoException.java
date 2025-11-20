package com.gsolution.saudemental.api.domain.exception;

public class RegistroDiarioNaoEncontradoException extends RuntimeException {

    public RegistroDiarioNaoEncontradoException(Long id) {
        super("Registro diário não encontrado. ID: " + id);
    }
}
