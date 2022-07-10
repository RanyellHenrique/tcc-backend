package br.com.unip.tcc.controllers;

import br.com.unip.tcc.dtos.requests.TrabalhadorRequest;
import br.com.unip.tcc.dtos.responses.TrabalhadorResponse;
import br.com.unip.tcc.services.TrabalhadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/trabalhadores")
@RequiredArgsConstructor
public class TrabalhadorController {

    private final TrabalhadorService service;

    @PostMapping
    public ResponseEntity<TrabalhadorResponse> insert(@RequestBody @Valid TrabalhadorRequest request) {
        var obj = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<TrabalhadorResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhadorResponse> findById(@PathVariable Long id) {
        var trabalhador = service.findById(id);
        if(trabalhador.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(trabalhador.get());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TrabalhadorResponse> update(@PathVariable Long id, @RequestBody @Valid TrabalhadorRequest request){
        var trabalhador = service.update(id, request);
        if(trabalhador.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(trabalhador.get());
    }

}
