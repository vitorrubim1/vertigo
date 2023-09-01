package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Jogador;
import br.com.fiap.vertigo.model.Time;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JogadorController {

    List<Jogador> jogadores = new ArrayList<>();

    private Jogador findJogadorById(Long id) {
        return jogadores.stream()
                .filter(Jogador -> Jogador.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @GetMapping("/jogadores")
    public List<Jogador> index() {
        return jogadores;
    }

    @PostMapping("/jogadores")
    public ResponseEntity<Object> create(@RequestBody Jogador jogador) {
        jogador.setId(jogadores.size() + 1L);
        jogadores.add(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogador);
    }

    @GetMapping("/jogadores/{id}")
    public ResponseEntity<Jogador> show(@PathVariable Long id) {
        Jogador jogadorEncontrado = findJogadorById(id);

        if (jogadorEncontrado == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(jogadorEncontrado);
    }

    @DeleteMapping("/jogadores/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        Jogador jogadorEncontrado = findJogadorById(id);

        if (jogadorEncontrado == null) return ResponseEntity.notFound().build();

        jogadores.remove(jogadorEncontrado);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/jogadores/{id}")
    public ResponseEntity<Jogador> update(@PathVariable Long id, @RequestBody Jogador jogador) {
        Jogador jogadorEncontrado = findJogadorById(id);
        if (jogadorEncontrado == null) return ResponseEntity.notFound().build();

        jogadores.remove(jogadorEncontrado);
        jogador.setId(id);
        jogadores.add(jogador);

        return ResponseEntity.ok(jogador);
    }
}
