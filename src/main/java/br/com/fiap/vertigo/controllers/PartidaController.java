package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Partida;
import br.com.fiap.vertigo.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partidas")
public class PartidaController {

    @Autowired
    private PartidaRepository partidaRepository;

    @GetMapping
    public List<Partida> index() {
        return partidaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Partida> create(@RequestBody Partida partida) {
        partida.setId(null);
        Partida savedPartida = partidaRepository.save(partida);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPartida);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> show(@PathVariable Long id) {
        Optional<Partida> partidaEncontrada = partidaRepository.findById(id);

        return partidaEncontrada.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        if (partidaRepository.existsById(id)) {
            partidaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partida> update(@PathVariable Long id, @RequestBody Partida partida) {
        if (partidaRepository.existsById(id)) {
            partida.setId(id);
            Partida updatedPartida = partidaRepository.save(partida);
            return ResponseEntity.ok(updatedPartida);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
