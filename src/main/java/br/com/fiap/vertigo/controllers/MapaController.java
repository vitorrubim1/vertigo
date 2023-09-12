package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Mapa;
import br.com.fiap.vertigo.repository.MapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MapaController {

    @Autowired
    private MapaRepository mapaRepository;

    @GetMapping
    public List<Mapa> index() {
        return mapaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Mapa> create(@RequestBody Mapa mapa) {
        mapaRepository.save(mapa);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapa);
    }

    @GetMapping("/mapas/{id}")
    public ResponseEntity<Mapa> show(@PathVariable Long id) {
        Optional<Mapa> mapaEncontrado = mapaRepository.findById(id);

        return mapaEncontrado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/mapas/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        if (mapaRepository.existsById(id)) {
            mapaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/mapas/{id}")
    public ResponseEntity<Mapa> update(@PathVariable Long id, @RequestBody Mapa mapa) {
        if (mapaRepository.existsById(id)) {
            mapa.setId(id);
            mapaRepository.save(mapa);
            return ResponseEntity.ok(mapa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
