package br.com.unip.tcc.controllers;

import br.com.unip.tcc.dtos.requests.AvaliacaoTrabalhadorRequest;
import br.com.unip.tcc.dtos.requests.PropostaAnaliseRequest;
import br.com.unip.tcc.dtos.requests.PropostaRequest;
import br.com.unip.tcc.dtos.responses.PropostaResponse;
import br.com.unip.tcc.services.PropostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = "/propostas")
@RequiredArgsConstructor
public class PropostaController {

    private final PropostaService service;

    @PostMapping()
    public ResponseEntity<PropostaResponse> insert(@AuthenticationPrincipal String trabalhador, @RequestBody @Valid PropostaRequest request) {
        PropostaResponse obj = service.insert(request, trabalhador);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropostaResponse> findById(@AuthenticationPrincipal String clienteEmail, @PathVariable Long id) {
        return ResponseEntity.ok(service.findById(clienteEmail, id));
    }

    @GetMapping("/clientes")
    public ResponseEntity<Page<PropostaResponse>> findAllByCliente(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "oferta_id", defaultValue = "") Long ofertaId,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "dataDeCadastro") String orderBy,
            @AuthenticationPrincipal String clienteEmail) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return ResponseEntity.ok(service.findByCliente(clienteEmail, ofertaId, pageRequest));
    }

    @GetMapping("/trabalhadores")
    public ResponseEntity<Page<PropostaResponse>> findAllByTrabalhador(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "oferta_id", defaultValue = "") Long ofertaId,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "dataDeCadastro") String orderBy,
            @AuthenticationPrincipal String trabalhadorEmail) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return ResponseEntity.ok(service.findByTrabalhador(trabalhadorEmail, ofertaId, pageRequest));
    }

    @PutMapping()
    public ResponseEntity<PropostaResponse> evalueteProposta(@AuthenticationPrincipal String cliente, @RequestBody @Valid PropostaAnaliseRequest request) {
        var proposta = service.evalueteProposta(request, cliente);
        if (proposta.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PropostaResponse> evalueteProposta(@AuthenticationPrincipal String cliente, @RequestBody @Valid PropostaAnaliseRequest request, @PathVariable Long id) {
        var proposta = service.evaluetePropostaById(request, cliente, id);
        if (proposta.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/avaliacoes")
    public ResponseEntity<PropostaResponse> insertAvaliacao(@AuthenticationPrincipal String cliente, @RequestBody @Valid AvaliacaoTrabalhadorRequest request, @PathVariable Long id) {
        var proposta = service.AvaliacaoTrabalhadorById(request, cliente, id);
        if (proposta.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

}
