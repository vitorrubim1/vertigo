package br.com.fiap.vertigo.repository;

import br.com.fiap.vertigo.model.Time;
import br.com.fiap.vertigo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findById(long id);
}
