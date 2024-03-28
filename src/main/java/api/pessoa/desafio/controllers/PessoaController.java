package api.pessoa.desafio.controllers;

import java.time.LocalDate;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import api.pessoa.desafio.dtos.PessoaRequest;
import api.pessoa.desafio.dtos.PessoaResponse;
import api.pessoa.desafio.services.PessoaService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/pessoas")
public class PessoaController {
    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public List<PessoaResponse> listarPessoas(
        @RequestParam(required = false) String nome,
        @RequestParam(required = false) String cpf,
        @RequestParam(required = false) String sobrenome,
        @RequestParam(required = false) Long status,
        @RequestParam(required = false, name = "data_inicial") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataInicial,
        @RequestParam(required = false, name = "data_final") @DateTimeFormat(pattern = "dd-MM-yyyy") LocalDate dataFinal
    ) {
        return pessoaService.listarPessoas(nome, cpf, sobrenome, status, dataInicial, dataFinal);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> removerPessoa(@PathVariable Long id) {
        pessoaService.removerPessoa(id);
        return ResponseEntity.status(Response.SC_NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> atualizarPessoa(@PathVariable Long id, @RequestBody @Valid PessoaRequest request) {
        pessoaService.atualizarPessoa(id, request);
        return ResponseEntity.status(Response.SC_NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<?> criarPessoa(@RequestBody @Valid PessoaRequest request) {
        pessoaService.criarPessoa(request);
        return ResponseEntity.status(Response.SC_CREATED).build();
    }
}
