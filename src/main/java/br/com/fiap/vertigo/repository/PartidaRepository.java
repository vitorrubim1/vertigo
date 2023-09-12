package br.com.fiap.vertigo.repository;

import br.com.fiap.vertigo.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PartidaRepository extends JpaRepository<Partida, Long> {
    List<Partida> findById(long id);
}