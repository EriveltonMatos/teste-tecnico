package api.pessoa.desafio.specifications;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.domain.Specification;

import api.pessoa.desafio.entities.Pessoa;

public class PessoaSpecifications {
    public static Specification<Pessoa> comNome(String nome) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Pessoa> comCpf(String cpf) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("cpf"), cpf);
    }

    public static Specification<Pessoa> comSobreNome(String sobrenome) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("sobrenome"), "%" + sobrenome + "%");
    }

    public static Specification<Pessoa> comStatus(Long status) {
        return (root, query, criteriaBuilder) -> {
            root.join("status");
            return criteriaBuilder.equal(root.get("status").get("id"), status);
        };
    }

    public static Specification<Pessoa> criadoDepoisDe(LocalDate data) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("dataCadastro"), data.atTime(LocalTime.MIN));
    }

    public static Specification<Pessoa> criadoAntesDe(LocalDate data) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("dataCadastro"), data.atTime(LocalTime.MAX));
    }
}
