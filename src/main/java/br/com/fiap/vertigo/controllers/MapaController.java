package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Mapa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MapaController {

    List<Mapa> mapas = new ArrayList<>();

    private Mapa findMapaById(Long id) {
        return mapas.stream()
                .filter(mapa -> mapa.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @GetMapping("/mapas")
    public List<Mapa> index() {
        return mapas;
    }

    @PostMapping("/mapas")
    public ResponseEntity<Mapa> create(@RequestBody Mapa mapa) {
        mapa.setId(mapas.size() + 1L);
        mapas.add(mapa);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapa);
    }

    @GetMapping("/mapas/{id}")
    public ResponseEntity<Mapa> show(@PathVariable Long id) {
        Mapa mapaEncontrado = findMapaById(id);

        if (mapaEncontrado == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(mapaEncontrado);
    }

    @DeleteMapping("/mapas/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        Mapa mapaEncontrado = findMapaById(id);

        if (mapaEncontrado == null) return ResponseEntity.notFound().build();

        mapas.remove(mapaEncontrado);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/mapas/{id}")
    public ResponseEntity<Mapa> update(@PathVariable Long id, @RequestBody Mapa mapa) {
        Mapa mapaEncontrado = findMapaById(id);
        if (mapaEncontrado == null) return ResponseEntity.notFound().build();

        mapas.remove(mapaEncontrado);
        mapa.setId(id);
        mapas.add(mapa);

        return ResponseEntity.ok(mapa);
    }
}
