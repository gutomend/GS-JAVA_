package com.gsolution.saudemental.api.domain.service;


import com.gsolution.saudemental.api.domain.exception.PacienteNaoEncontradoException;
import com.gsolution.saudemental.api.domain.model.Paciente;
import com.gsolution.saudemental.api.domain.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> listar() {
        return repository.findAll();
    }

    public Paciente buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PacienteNaoEncontradoException(id));
    }

    public Paciente salvar(Paciente paciente) {
        return repository.save(paciente);
    }

    public Paciente atualizar(Long id, Paciente dados) {
        Paciente p = buscar(id);
        p.setNome(dados.getNome());
        p.setEmail(dados.getEmail());
        p.setDataNascimento(dados.getDataNascimento());
        return repository.save(p);
    }

    public void remover(Long id) {
        repository.delete(buscar(id));
    }
}