package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Usuario;
import br.com.fiap.vertigo.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    @Autowired
    UsuarioRepository repository;

    @GetMapping("/usuarios")
    public List<Usuario> index() {
        return repository.findAll();
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id) {
        return ResponseEntity.ok(getUsuarioById(id));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        repository.delete(getUsuarioById(id));

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        getUsuarioById(id);
        usuario.setId(id);
        repository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    private Usuario getUsuarioById(Long id) {
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }
}
