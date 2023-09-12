package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Time;
import br.com.fiap.vertigo.model.Usuario;
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
    TimeRepository timeRepository;

    @GetMapping
    public List<Time> index() {
        return timeRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Time> create(@RequestBody Time time) {
        timeRepository.save(time);
        return ResponseEntity.status(HttpStatus.CREATED).body(time);
    }

    @GetMapping("/times/{id}")
    public ResponseEntity<Time> show(@PathVariable Long id)
        {return ResponseEntity.ok(getTimeById(id));}

    @DeleteMapping("/times/{id}")
        public ResponseEntity<Object> destroy (@PathVariable Long id){
            timeRepository.delete(getTimeById(id));

            return ResponseEntity.noContent().build();}
    @PutMapping("/times/{id}")
        public ResponseEntity<Time> update (@PathVariable Long id, @RequestBody Time time){
            getTimeById(id);
            time.setId(id);
            timeRepository.save(time);

            return ResponseEntity.ok(time);}
    private Time getTimeById (Long id){
            return timeRepository.findById(id).orElseThrow(RuntimeException::new);
        }

}



