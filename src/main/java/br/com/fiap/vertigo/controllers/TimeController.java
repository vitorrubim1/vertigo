package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Time;
import br.com.fiap.vertigo.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TimeController {

    @Autowired
    private TimeRepository timeRepository;

    @GetMapping
    public List<Time> index() {
        return timeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Time> create(@RequestBody Time time) {
        time.setId(null);
        Time savedTime = timeRepository.save(time);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTime);
    }

    @GetMapping("/times/{id}")
    public ResponseEntity<Time> show(@PathVariable Long id) {
        Optional<Time> timeEncontrado = timeRepository.findById(id);

        return timeEncontrado.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/times/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        if (timeRepository.existsById(id)) {
            timeRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/times/{id}")
    public ResponseEntity<Time> update(@PathVariable Long id, @RequestBody Time time) {
        if (timeRepository.existsById(id)) {
            time.setId(id);
            Time updatedTime = timeRepository.save(time);
            return ResponseEntity.ok(updatedTime);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
