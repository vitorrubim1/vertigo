package br.com.fiap.vertigo.repository;

import br.com.fiap.vertigo.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    List<Jogador> findAllById(Long id);
}




