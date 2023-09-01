package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Time;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TimeController {

    List<Time> times = new ArrayList<>();

    public Time findTimeById(Long id) {
        return times.stream()
                .filter(time -> time.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @GetMapping("/times")
    public List<Time> index() {
        return times;
    }

    @PostMapping("/times")
    public ResponseEntity<Time> create(@RequestBody Time time) {
        time.setId(times.size() + 1L);
        times.add(time);
        return ResponseEntity.status(HttpStatus.CREATED).body(time);
    }

    @GetMapping("/times/{id}")
    public ResponseEntity<Time> show(@PathVariable Long id) {
        Time timeEncontrado = findTimeById(id);

        if (timeEncontrado == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(timeEncontrado);
    }

    @DeleteMapping("/times/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        Time timeEncontrado = findTimeById(id);

        if (timeEncontrado == null) return ResponseEntity.notFound().build();

        times.remove(timeEncontrado);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/times/{id}")
    public ResponseEntity<Time> update(@PathVariable Long id, @RequestBody Time time) {
        Time timeEncontrado = findTimeById(id);
        if (timeEncontrado == null) return ResponseEntity.notFound().build();

        times.remove(timeEncontrado);
        time.setId(id);
        times.add(time);

        return ResponseEntity.ok(time);
    }
}
