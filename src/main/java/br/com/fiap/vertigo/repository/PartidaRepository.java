package br.com.fiap.vertigo.repository;

import br.com.fiap.vertigo.model.Partida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;


public interface PartidaRepository extends JpaRepository<Partida, Long> {
    List<Partida> findById(long id);

    @Query("SELECT p FROM Partida p WHERE p.data_partida = :dataPartida")
    Page<Partida> findByDataPartida(
            @Param("dataPartida") LocalDateTime dataPartida,
            Pageable pageable);
}