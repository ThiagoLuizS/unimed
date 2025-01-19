package br.com.seguro.unimed.resource;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public interface IResource<Entity, View, Form> {

    @GetMapping("/{id}")
    View getById(@PathVariable("id") Long id);

    @GetMapping
    Page<View> getAll(@RequestParam(defaultValue = "0") int page,
                      @RequestParam(defaultValue = "10") int size);

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    View save(@Valid @RequestBody Form form);

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    View update(@PathVariable("id") Long id,
                               @Valid @RequestBody Form form);
}
