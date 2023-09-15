package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Jogador;
import br.com.fiap.vertigo.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    JogadorRepository jogadorRepository;

    @GetMapping
    public List<Jogador> index() {
        return jogadorRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Jogador> create(@RequestBody Jogador jogador) {
        jogadorRepository.save(jogador);
        return ResponseEntity.status(HttpStatus.CREATED).body(jogador);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> show(@PathVariable Long id) {return ResponseEntity.ok(getJogadorById(id));}

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroy (@PathVariable Long id){
        jogadorRepository.delete(getJogadorById(id));

        return ResponseEntity.noContent().build();}

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> update(@PathVariable Long id, @RequestBody Jogador jogador) {
        getJogadorById(id);
        jogador.setId(id);
        jogadorRepository.save(jogador);

        return ResponseEntity.ok(jogador);
    }
    private Jogador getJogadorById(Long id) {
        return jogadorRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
