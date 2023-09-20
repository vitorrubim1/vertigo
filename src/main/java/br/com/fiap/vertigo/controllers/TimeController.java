package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Time;
import br.com.fiap.vertigo.model.Usuario;
import br.com.fiap.vertigo.repository.TimeRepository;
import br.com.fiap.vertigo.validation.RestValidationError;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class TimeController {

    @Autowired
    TimeRepository timeRepository;

    @GetMapping("/times")
    public List<Time> index() {
        log.info("buscando todos os times");
        return timeRepository.findAll();
    }

    @PostMapping("/time")
    public ResponseEntity<Object> create(@RequestBody @Valid Time time) {
        log.info("cadastrando time " + time);
        timeRepository.save(time);
        return ResponseEntity.status(HttpStatus.CREATED).body(time);
    }

    @GetMapping("/time/{id}")
    public ResponseEntity<Time> show(@PathVariable Long id) {
        return ResponseEntity.ok(getTimeById(id));
    };

    @DeleteMapping("/time/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        timeRepository.delete(getTimeById(id));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/time/{id}")
    public ResponseEntity<Time> update(@PathVariable Long id, @RequestBody @Valid Time time) {
        getTimeById(id);
        time.setId(id);
        timeRepository.save(time);

        return ResponseEntity.ok(time);
    }

    private Time getTimeById(Long id) {
        return timeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

}



