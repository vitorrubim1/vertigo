package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Campeonato;
import br.com.fiap.vertigo.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/campeonatos")
public class CampeonatoController {

    @Autowired
    private CampeonatoRepository campeonatoRepository;

    @GetMapping
    public List<Campeonato> index() {
        return campeonatoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Campeonato> create(@RequestBody Campeonato campeonato) {
        campeonato.setId(null);
        Campeonato savedCampeonato = campeonatoRepository.save(campeonato);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCampeonato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campeonato> show(@PathVariable Long id) {
        Optional<Campeonato> campeonatoEncontrado = campeonatoRepository.findById(id);

        return campeonatoEncontrado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        if (campeonatoRepository.existsById(id)) {
            campeonatoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Campeonato> update(@PathVariable Long id, @RequestBody Campeonato campeonato) {
        if (campeonatoRepository.existsById(id)) {
            campeonato.setId(id);
            Campeonato updatedCampeonato = campeonatoRepository.save(campeonato);
            return ResponseEntity.ok(updatedCampeonato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
