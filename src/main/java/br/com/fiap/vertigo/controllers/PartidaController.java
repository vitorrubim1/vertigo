package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Campeonato;
import br.com.fiap.vertigo.model.Partida;
import org.springframework.web.bind.annotation.CrossOrigin;
import br.com.fiap.vertigo.model.Time;
import br.com.fiap.vertigo.repository.CampeonatoRepository;
import br.com.fiap.vertigo.repository.PartidaRepository;
import br.com.fiap.vertigo.repository.TimeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PartidaController {
    @Autowired
    PartidaRepository partidaRepository;
    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @PostMapping("/partida")
    public ResponseEntity<Partida> createPartida(@RequestBody @Valid Partida partida) {
        List<Time> times = new ArrayList<>();
        for (Time time : partida.getTimes()) {
            Optional<Time> existingTime = timeRepository.findById(time.getId());
            existingTime.ifPresent(times::add);
        }

        Optional<Campeonato> existingCampeonato = campeonatoRepository.findById(partida.getNome_campeonato().getId());
        Campeonato campeonato = existingCampeonato.orElse(null);

        partida.setTimes(times);
        partida.setNome_campeonato(campeonato);

        Partida savedPartida = partidaRepository.save(partida);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPartida);
    }


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

