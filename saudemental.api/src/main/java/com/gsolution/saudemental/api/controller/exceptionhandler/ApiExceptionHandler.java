package com.gsolution.saudemental.api.controller.exceptionhandler;

import com.gsolution.saudemental.api.domain.exception.*;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validar(MethodArgumentNotValidException ex) {

        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors()
                .forEach(e -> erros.put(e.getField(), e.getDefaultMessage()));

        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler(PacienteNaoEncontradoException.class)
    public ResponseEntity<String> pacienteNaoEncontrado(PacienteNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(RegistroDiarioNaoEncontradoException.class)
    public ResponseEntity<String> registroNaoEncontrado(RegistroDiarioNaoEncontradoException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}