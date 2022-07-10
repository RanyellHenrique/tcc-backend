package br.com.unip.tcc.controllers;

import br.com.unip.tcc.dtos.requests.OfertaRequest;
import br.com.unip.tcc.dtos.responses.OfertaResponse;
import br.com.unip.tcc.services.OfertaService;
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
import java.util.List;

@RestController
@RequestMapping(value = "/ofertas")
@RequiredArgsConstructor
public class OfertaController {

    private final OfertaService service;

    @PostMapping
    public ResponseEntity<OfertaResponse> insert(@RequestBody @Valid OfertaRequest request, @AuthenticationPrincipal String cliente) {
        var obj = service.insert(request, cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping
    public ResponseEntity<Page<OfertaResponse>> findAllPage(@RequestParam(value = "categorias", defaultValue = "0") Long categoria,
                                                        @RequestParam(value = "page", defaultValue = "0") Integer page,
                                                        @RequestParam(value = "titulo", defaultValue = "") String titulo,
                                                        @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
                                                        @RequestParam(value = "direction", defaultValue = "ASC") String direction,
                                                        @RequestParam(value = "orderBy", defaultValue = "id") String orderBy) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);

        return ResponseEntity.ok(service.findAllPage(categoria, titulo, pageRequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfertaResponse> findById(@PathVariable Long id) {
        var oferta = service.findById(id);
        if(oferta.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(oferta.get());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<OfertaResponse> update(@PathVariable Long id, @RequestBody @Valid OfertaRequest request){
        var oferta = service.update(id, request);
        if(oferta.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(oferta.get());
    }

}
