package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Partida;
import br.com.fiap.vertigo.model.Time;
import br.com.fiap.vertigo.model.Usuario;
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
    PartidaRepository partidaRepository;

    @GetMapping
    public ResponseEntity<List<Partida>> getAllPartidas() {
        List<Partida> partidas = partidaRepository.findAll();
        return ResponseEntity.ok(partidas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Partida> getPartida(@PathVariable Long id) {
        Partida partida = getPartidaById(id);
        return ResponseEntity.ok(partida);
    }

    @PostMapping
    public ResponseEntity<Partida> createPartida(@RequestBody Partida partida) {
        Partida savedPartida = partidaRepository.save(partida);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPartida);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Partida> updatePartida(@PathVariable Long id, @RequestBody Partida updatedPartida) {
        Partida existingPartida = getPartidaById(id);
        updatedPartida.setId(existingPartida.getId());
        Partida savedPartida = partidaRepository.save(updatedPartida);
        return ResponseEntity.ok(savedPartida);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePartida(@PathVariable Long id) {
        Partida partida = getPartidaById(id);
        partidaRepository.delete(partida);
        return ResponseEntity.noContent().build();
    }
    private Partida getPartidaById(Long id) {
        return partidaRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}

