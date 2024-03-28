package api.pessoa.desafio.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import api.pessoa.desafio.dtos.PessoaRequest;
import api.pessoa.desafio.dtos.PessoaResponse;
import api.pessoa.desafio.entities.Pessoa;
import api.pessoa.desafio.exceptions.PessoaNotFoundException;
import api.pessoa.desafio.repositories.PessoaRepository;
import api.pessoa.desafio.specifications.PessoaSpecifications;

@Service
public class PessoaService {
    private final PessoaRepository pessoaRepository;
    private final StatusService statusService;

    public PessoaService(PessoaRepository pessoaRepository, StatusService statusService) {
        this.pessoaRepository = pessoaRepository;
        this.statusService = statusService;
    }

    public List<PessoaResponse> listarPessoas(
        String nome,
        String cpf,
        String sobrenome,
        Long status,
        LocalDate dataCriacaoInicial,
        LocalDate dataCriacaoFinal
    ) {
        var specifications = createSpecificationsList(nome, cpf, sobrenome, status, dataCriacaoInicial, dataCriacaoFinal);
        return pessoaRepository.findAll(Specification.where(specifications))
            .stream()
            .map(PessoaResponse::new)
            .collect(Collectors.toList());
    }

    public void removerPessoa(Long id) {
        pessoaRepository.deleteById(id);
    }

    public void atualizarPessoa(Long id, PessoaRequest request) {
        Pessoa pessoa = tryOrThrow(id);
        pessoa.setNome(request.nome());
        pessoa.setSobrenome(request.sobrenome());
        pessoa.setCpf(request.cpf());
        pessoa.setStatus(statusService.findById(request.statusId()));
        pessoaRepository.save(pessoa);
    }

    private Pessoa tryOrThrow(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new PessoaNotFoundException("Pessoa não encontrada"));
    }

    public PessoaResponse criarPessoa(PessoaRequest request) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(request.nome());
        pessoa.setSobrenome(request.sobrenome());
        pessoa.setCpf(request.cpf());
        pessoa.setStatus(statusService.findById(request.statusId()));
        return new PessoaResponse(pessoaRepository.save(pessoa));
    }

    private Specification<Pessoa> createSpecificationsList(String nome, String cpf, String sobrenome, Long status, LocalDate dataCriacaoInicial, LocalDate dataCriacaoFinal) {
        List<Specification<Pessoa>> specs = new ArrayList<>();
        if (nome != null) {
            specs.add(PessoaSpecifications.comNome(nome));
        }
        if (cpf != null) {
            specs.add(PessoaSpecifications.comCpf(cpf));
        }
        if (sobrenome != null) {
            specs.add(PessoaSpecifications.comSobreNome(sobrenome));
        }
        if (status != null) {
            specs.add(PessoaSpecifications.comStatus(status));
        }
        if (dataCriacaoInicial != null) {
            specs.add(PessoaSpecifications.criadoDepoisDe(dataCriacaoInicial));
        }
        if (dataCriacaoFinal != null) {
            specs.add(PessoaSpecifications.criadoAntesDe(dataCriacaoFinal));
        }
        return specs.stream().reduce(Specification::and).orElse(null);
    }

}
