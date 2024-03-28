package api.pessoa.desafio.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PessoaRequest(
    @NotBlank(message = "campo obrigatório") String nome,
    @NotBlank(message = "campo obrigatório") String sobrenome,
    @NotBlank(message = "campo obrigatório") String cpf,
    @NotNull(message = "campo obrigatório") @JsonProperty("status_id") Long statusId
) {

}
