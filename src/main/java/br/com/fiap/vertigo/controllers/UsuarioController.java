package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Usuario;
import br.com.fiap.vertigo.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioRepository repository;

    @GetMapping("/usuarios")
    public List<Usuario> index() {
        return repository.findAll();
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario) {
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id) {
        return ResponseEntity.ok(getUsuarioById(id));
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        repository.delete(getUsuarioById(id));

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
        getUsuarioById(id);
        usuario.setId(id);
        repository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    private Usuario getUsuarioById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível encontrar o usuário com id: " + id));
    }
}
