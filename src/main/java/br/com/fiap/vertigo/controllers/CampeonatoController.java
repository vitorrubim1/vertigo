package br.com.fiap.vertigo.controllers;

import br.com.fiap.vertigo.model.Campeonato;
import br.com.fiap.vertigo.model.Jogador;
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
    CampeonatoRepository campeonatoRepository;

    @GetMapping
    public List<Campeonato> index() {
        return campeonatoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Campeonato> create(@RequestBody Campeonato campeonato) {
        campeonatoRepository.save(campeonato);
        return ResponseEntity.status(HttpStatus.CREATED).body(campeonato);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Campeonato> show(@PathVariable Long id) {return ResponseEntity.ok(getCampeonatoById(id));}

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroy (@PathVariable Long id){
        campeonatoRepository.delete(getCampeonatoById(id));

        return ResponseEntity.noContent().build();}

    @PutMapping("/{id}")
    public ResponseEntity<Campeonato> update(@PathVariable Long id, @RequestBody Campeonato campeonato) {
        getCampeonatoById(id);
        campeonato.setId(id);
        campeonatoRepository.save(campeonato);

        return ResponseEntity.ok(campeonato);
    }
    private Campeonato getCampeonatoById(Long id) {
        return campeonatoRepository.findById(id).orElseThrow(RuntimeException::new);
    }
}
