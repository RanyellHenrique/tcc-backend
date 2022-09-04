package br.com.unip.tcc.controllers;

import br.com.unip.tcc.dtos.requests.CategoriaRequest;
import br.com.unip.tcc.dtos.responses.CategoriaResponse;
import br.com.unip.tcc.dtos.responses.OfertaResponse;
import br.com.unip.tcc.services.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService service;

    @PostMapping
    public ResponseEntity<CategoriaResponse> insert(@RequestBody @Valid CategoriaRequest request) {
        var obj = service.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/pages")
    public ResponseEntity<Page<CategoriaResponse>> findAllPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                            @RequestParam(value = "nome", defaultValue = "") String nome,
                                                            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
                                                            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return ResponseEntity.ok(service.findAllPage(nome, pageRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> findById(@PathVariable Long id) {
        var categoria = service.findById(id);
        if(categoria.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categoria.get());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaResponse> update(@PathVariable Long id, @RequestBody @Valid CategoriaRequest request){
        var categoria = service.update(id, request);
        if(categoria.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(categoria.get());
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
