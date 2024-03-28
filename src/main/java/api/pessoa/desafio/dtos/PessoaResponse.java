package api.pessoa.desafio.dtos;

import java.time.LocalDateTime;

import api.pessoa.desafio.entities.Pessoa;

public record PessoaResponse(
    Long id,
    String nome,
    String sobrenome,
    String cpf,
    LocalDateTime dataCadastro,
    String status
) {
    public PessoaResponse(Pessoa pessoa) {
        this(pessoa.getId(), pessoa.getNome(), pessoa.getSobrenome(), pessoa.getCpf(), pessoa.getDataCadastro(), pessoa.getStatus().getDescricao());
    }
}
