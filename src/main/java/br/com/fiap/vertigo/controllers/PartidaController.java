package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Partida;
import br.com.fiap.vertigo.model.Time;
import br.com.fiap.vertigo.model.Usuario;
import br.com.fiap.vertigo.repository.PartidaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class PartidaController {
    @Autowired
    PartidaRepository partidaRepository;
    
    TimeController timeController = new TimeController();

    @GetMapping("/partidas")
    public ResponseEntity<List<Partida>> getAllPartidas() {
        List<Partida> partidas = partidaRepository.findAll();
        return ResponseEntity.ok(partidas);
    }

    @GetMapping("/partida/{id}")
    public ResponseEntity<Partida> getPartida(@PathVariable Long id) {
        Partida partida = getPartidaById(id);
        return ResponseEntity.ok(partida);
    }

    @PostMapping("/partida")
    public ResponseEntity<Partida> createPartida(@RequestBody @Valid Partida partida) {
        System.out.println("\n\n teste: " + partida);

        // ### Isso aqui era para realizar validação para saber se os times que estão vindo existem
        //        for (Time time : partida.getTime()) {
        //            Long time_id = time.getId();
        //
        //            timeController.timeRepository.findById(time_id)
        //                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível encontrar o time com id: " + time_id));
        //        }

        Partida savedPartida = partidaRepository.save(partida);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPartida);
    }

    @PutMapping("/partida/{id}")
    public ResponseEntity<Partida> updatePartida(@PathVariable Long id, @RequestBody @Valid Partida updatedPartida) {
        Partida existingPartida = getPartidaById(id);
        updatedPartida.setId(existingPartida.getId());
        Partida savedPartida = partidaRepository.save(updatedPartida);
        return ResponseEntity.ok(savedPartida);
    }

    @DeleteMapping("/partida/{id}")
    public ResponseEntity<Void> deletePartida(@PathVariable Long id) {
        Partida partida = getPartidaById(id);
        partidaRepository.delete(partida);
        return ResponseEntity.noContent().build();
    }
    private Partida getPartidaById(Long id) {
        return partidaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível encontrar a partida com id: " + id));
    }
}

