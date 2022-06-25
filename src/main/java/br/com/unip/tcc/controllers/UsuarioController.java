package br.com.unip.tcc.controllers;

import br.com.unip.tcc.dtos.requests.UsuarioRequest;
import br.com.unip.tcc.dtos.responses.UsuarioResponse;
import br.com.unip.tcc.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponse> insert(@RequestBody @Valid UsuarioRequest request) {
        var obj = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> findById(@PathVariable Long id) {
        var usuario = service.findById(id);
        if(usuario.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(usuario.get());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsuarioResponse> update(@PathVariable Long id, @RequestBody @Valid UsuarioRequest request){
        var usuario = service.update(id, request);
        if(usuario.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(usuario.get());
    }

}
