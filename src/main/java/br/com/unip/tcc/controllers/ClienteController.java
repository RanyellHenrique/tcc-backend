package br.com.unip.tcc.controllers;

import br.com.unip.tcc.dtos.requests.ClienteRequest;
import br.com.unip.tcc.dtos.responses.ClienteResponse;
import br.com.unip.tcc.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<ClienteResponse> insert(@RequestBody @Valid ClienteRequest request) {
        var obj = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> findById(@PathVariable Long id) {
        var Cliente = service.findById(id);
        if(Cliente.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(Cliente.get());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClienteResponse> update(@PathVariable Long id, @RequestBody @Valid ClienteRequest request){
        var Cliente = service.update(id, request);
        if(Cliente.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(Cliente.get());
    }

}
