package api.pessoa.desafio.dtos;

import jakarta.validation.constraints.NotBlank;

public record StatusRequest(
    @NotBlank(message = "campo obrigatório") String descricao
) {

}
