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
public class PartidaController {

    @Autowired
    PartidaRepository partidaRepository;

    @GetMapping
    public List<Partida> index() {
        return partidaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Partida> create(@RequestBody Partida partida) {
        partidaRepository.save(partida);
        return ResponseEntity.status(HttpStatus.CREATED).body(partida);
    }

    @GetMapping("/partidas/{id}")
    public ResponseEntity<Partida> show(@PathVariable Long id) {return ResponseEntity.ok(getPartidaById(id));}

    @DeleteMapping("/partidas/{id}")
    public ResponseEntity<Object> destroy (@PathVariable Long id){
        partidaRepository.delete(getPartidaById(id));

        return ResponseEntity.noContent().build();}

    @PutMapping("/partidas/{id}")
    public ResponseEntity<Partida> update(@PathVariable Long id, @RequestBody Partida partida) {
        getPartidaById(id);
        partida.setId(id);
        partidaRepository.save(partida);

        return ResponseEntity.ok(partida);
    }
    private Partida getPartidaById(Long id) {
        return partidaRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}

