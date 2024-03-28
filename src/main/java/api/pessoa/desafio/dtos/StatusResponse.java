package api.pessoa.desafio.dtos;

import api.pessoa.desafio.entities.Status;

public record StatusResponse(
    Long id,    
    String descricao
) {
    public StatusResponse(Status status) {
        this(status.getId(), status.getDescricao());
    }
}
