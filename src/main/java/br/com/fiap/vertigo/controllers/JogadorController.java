package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Jogador;
import br.com.fiap.vertigo.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    @GetMapping
    public List<Jogador> index() {
        return jogadorRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Jogador> create(@RequestBody Jogador jogador) {
        Jogador novoJogador = jogadorRepository.save(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoJogador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> show(@PathVariable Long id) {
        Optional<Jogador> jogadorEncontrado = jogadorRepository.findById(id);

        if (jogadorEncontrado.isPresent()) {
            return ResponseEntity.ok(jogadorEncontrado.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/jogadores/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        if (jogadorRepository.existsById(id)) {
            jogadorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/jogadores/{id}")
    public ResponseEntity<Jogador> update(@PathVariable Long id, @RequestBody Jogador jogador) {
        if (jogadorRepository.existsById(id)) {
            jogador.setId(id);
            Jogador jogadorAtualizado = jogadorRepository.save(jogador);
            return ResponseEntity.ok(jogadorAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/jogadores/{nome_jogador}")
    public List<Jogador> findByNome(@PathVariable String nome_jogador) {
        return jogadorRepository.findByNome_jogador(nome_jogador);
    }
}
