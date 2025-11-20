package com.gsolution.saudemental.api.domain.service;

import com.gsolution.saudemental.api.domain.exception.RegistroDiarioNaoEncontradoException;
import com.gsolution.saudemental.api.domain.model.RegistroDiario;
import com.gsolution.saudemental.api.domain.repository.RegistroDiarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroDiarioService {

    private final RegistroDiarioRepository repository;

    public RegistroDiarioService(RegistroDiarioRepository repository) {
        this.repository = repository;
    }

    public List<RegistroDiario> listar() {
        return repository.findAll();
    }

    public RegistroDiario buscar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RegistroDiarioNaoEncontradoException(id));
    }

    public RegistroDiario salvar(RegistroDiario registro) {
        return repository.save(registro);
    }

    public RegistroDiario atualizar(Long id, RegistroDiario dados) {
        RegistroDiario r = buscar(id);

        r.setDataRegistro(dados.getDataRegistro());
        r.setNivelHumor(dados.getNivelHumor());
        r.setNivelAnsiedade(dados.getNivelAnsiedade());
        r.setHorasSono(dados.getHorasSono());

        return repository.save(r);
    }

    public void remover(Long id) {
        repository.delete(buscar(id));
    }
}