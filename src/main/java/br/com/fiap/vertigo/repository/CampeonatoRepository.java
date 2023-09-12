package br.com.fiap.vertigo.repository;

import br.com.fiap.vertigo.model.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {
    List<Campeonato> findById(long id);
}

