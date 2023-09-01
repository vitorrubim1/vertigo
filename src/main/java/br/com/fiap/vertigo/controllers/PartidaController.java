package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Partida;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PartidaController {
    List<Partida> partidas = new ArrayList<>();

    private Partida findPartidaById(Long id) {
        return partidas.stream()
                .filter(Partida -> Partida.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @GetMapping("/partidas")
    public List<Partida> index() {
        return partidas;
    }

    @PostMapping("/partidas")
    public ResponseEntity<Partida> create(@RequestBody Partida partida) {
        partida.setId(partidas.size() + 1L);
        partidas.add(partida);
        return ResponseEntity.status(HttpStatus.CREATED).body(partida);
    }

    @GetMapping("/partidas/{id}")
    public ResponseEntity<Partida> show(@PathVariable Long id) {
        Partida partidaEncontrado = findPartidaById(id);

        if (partidaEncontrado == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(partidaEncontrado);
    }

    @DeleteMapping("/partidas/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        Partida partidaEncontrado = findPartidaById(id);

        if (partidaEncontrado == null) return ResponseEntity.notFound().build();

        partidas.remove(partidaEncontrado);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/partidas/{id}")
    public ResponseEntity<Partida> update(@PathVariable Long id, @RequestBody Partida partida) {
        Partida partidaEncontrado = findPartidaById(id);
        if (partidaEncontrado == null) return ResponseEntity.notFound().build();

        partidas.remove(partidaEncontrado);
        partida.setId(id);
        partidas.add(partida);

        return ResponseEntity.ok(partida);
    }
}

