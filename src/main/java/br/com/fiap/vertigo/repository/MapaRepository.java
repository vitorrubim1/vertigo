package br.com.fiap.vertigo.repository;

import br.com.fiap.vertigo.model.Mapa;
import br.com.fiap.vertigo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MapaRepository extends JpaRepository<Mapa, Long> {
    List<Mapa> findById(long id);
}

