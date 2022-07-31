package br.com.unip.tcc.controllers;

import br.com.unip.tcc.dtos.requests.PropostaRequest;
import br.com.unip.tcc.dtos.responses.PropostaResponse;
import br.com.unip.tcc.services.PropostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/propostas")
@RequiredArgsConstructor
public class PropostaController {

    private final PropostaService service;

    @PostMapping()
    public ResponseEntity<?> findById(@AuthenticationPrincipal String trabalhador, @RequestBody @Valid PropostaRequest request) {
        PropostaResponse obj = service.insert(request, trabalhador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
