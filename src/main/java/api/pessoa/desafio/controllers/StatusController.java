package api.pessoa.desafio.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.pessoa.desafio.dtos.StatusRequest;
import api.pessoa.desafio.dtos.StatusResponse;
import api.pessoa.desafio.services.StatusService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/status")
public class StatusController {
    private final StatusService statusService;
    
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @PostMapping
    public StatusResponse create(@RequestBody @Valid StatusRequest request) {
        return new StatusResponse(statusService.save(request.descricao()));
    }
}
