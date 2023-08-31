package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsuarioController {

    List<Usuario> usuarios = new ArrayList<>();

    private Usuario findUsuarioById(Long id) {
        return usuarios.stream()
                .filter(Usuario -> Usuario.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @GetMapping("/usuarios")
    public List<Usuario> index() {
        return usuarios;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> create(@RequestBody Usuario Usuario) {
        Usuario.setId(usuarios.size() + 1L);
        usuarios.add(Usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(Usuario);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id) {
        Usuario usuarioEncontrado = findUsuarioById(id);

        if (usuarioEncontrado == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(usuarioEncontrado);
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        Usuario usuarioEncontrado = findUsuarioById(id);

        if (usuarioEncontrado == null) return ResponseEntity.notFound().build();

        usuarios.remove(usuarioEncontrado);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario categoria) {
        Usuario usuarioEncontrado = findUsuarioById(id);
        if (usuarioEncontrado == null) return ResponseEntity.notFound().build();

        usuarios.remove(usuarioEncontrado);
        categoria.setId(id);
        usuarios.add(categoria);

        return ResponseEntity.ok(categoria);
    }
}
