package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Usuario;
import br.com.fiap.vertigo.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public ResponseEntity<Page<Usuario>> index(
            @PageableDefault(size = 3, sort = "id", direction = Sort.Direction.ASC) Pageable pageRequest) {
        Page<Usuario> usuarios = usuarioRepository.findAllWithPagination(pageRequest);
        return ResponseEntity.ok(usuarios);
    }



    @PostMapping("/usuario")
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario) {
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id) {
        return ResponseEntity.ok(getUsuarioById(id));
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        usuarioRepository.delete(getUsuarioById(id));

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
        getUsuarioById(id);
        usuario.setId(id);
        usuarioRepository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    private Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível encontrar o usuário com id: " + id));
    }
}
