package api.pessoa.desafio.services;

import org.springframework.stereotype.Service;

import api.pessoa.desafio.entities.Status;
import api.pessoa.desafio.exceptions.StatusNotFoundException;
import api.pessoa.desafio.repositories.StatusRepository;
import jakarta.validation.constraints.NotNull;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public Status save(@NotNull String descricao) {
        Status status = new Status();
        status.setDescricao(descricao);
        return statusRepository.save(status);
    }
    
    public Status findById(@NotNull Long id) {
        return tryOrThrow(id);
    }

    private Status tryOrThrow(Long id) {
        return statusRepository.findById(id).orElseThrow(() -> new StatusNotFoundException("Status não encontrado"));
    }
}
