package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Campeonato;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CampeonatoController {
    List<Campeonato> campeonatos = new ArrayList<>();

    private Campeonato findCampeonatoById(Long id) {
        return campeonatos.stream()
                .filter(Campeonato -> Campeonato.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @GetMapping("/campeonatos")
    public List<Campeonato> index() {
        return campeonatos;
    }

    @PostMapping("/campeonatos")
    public ResponseEntity<Campeonato> create(@RequestBody Campeonato partida) {
        partida.setId(campeonatos.size() + 1L);
        campeonatos.add(partida);
        return ResponseEntity.status(HttpStatus.CREATED).body(partida);
    }

    @GetMapping("/campeonatos/{id}")
    public ResponseEntity<Campeonato> show(@PathVariable Long id) {
        Campeonato partidaEncontrado = findCampeonatoById(id);

        if (partidaEncontrado == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(partidaEncontrado);
    }

    @DeleteMapping("/campeonatos/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        Campeonato partidaEncontrado = findCampeonatoById(id);

        if (partidaEncontrado == null) return ResponseEntity.notFound().build();

        campeonatos.remove(partidaEncontrado);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/campeonatos/{id}")
    public ResponseEntity<Campeonato> update(@PathVariable Long id, @RequestBody Campeonato partida) {
        Campeonato partidaEncontrado = findCampeonatoById(id);
        if (partidaEncontrado == null) return ResponseEntity.notFound().build();

        campeonatos.remove(partidaEncontrado);
        partida.setId(id);
        campeonatos.add(partida);

        return ResponseEntity.ok(partida);
    }
}