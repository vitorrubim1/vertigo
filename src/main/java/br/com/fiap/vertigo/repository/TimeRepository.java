package br.com.fiap.vertigo.repository;

import br.com.fiap.vertigo.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TimeRepository extends JpaRepository<Time, Long> {
    List<Time> findById(long id);
}

