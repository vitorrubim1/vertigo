package br.com.fiap.vertigo.config;

import br.com.fiap.vertigo.model.Campeonato;
import br.com.fiap.vertigo.model.Partida;
import br.com.fiap.vertigo.model.Time;
import br.com.fiap.vertigo.model.Usuario;
import br.com.fiap.vertigo.repository.CampeonatoRepository;
import br.com.fiap.vertigo.repository.PartidaRepository;
import br.com.fiap.vertigo.repository.TimeRepository;
import br.com.fiap.vertigo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataBaseSeeder implements CommandLineRunner  {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TimeRepository timeRepository;
    @Autowired
    CampeonatoRepository campeonatoRepository;

    @Override
    public void run(String... args) throws Exception {
        usuarioRepository.saveAll(
          List.of(
                  new Usuario(null, "Vitor","vitor@gmail.com", "1234" ),
                  new Usuario(null, "Gustavo","gustavo@gmail.com", "1234" ),
                  new Usuario(null, "Natan","natan@gmail.com", "1234" )
          )
        );
        timeRepository.saveAll(
                List.of(
                        new Time(null, 35, 10, "https://www.imagem.com", "LOUD"),
                        new Time(null, 30, 15, "https://www.imagem.com", "FLUXO"),
                        new Time(null, 32, 13, "https://www.imagem.com", "RED CANIDS"),
                        new Time(null, 28, 17, "https://www.imagem.com", "KEYD"),
                        new Time(null, 33, 12, "https://www.imagem.com", "PAIN"),
                        new Time(null, 26, 19, "https://www.imagem.com", "FURIA")

                )
        );
        campeonatoRepository.saveAll(
                List.of(
                       new Campeonato(null, "CBLOL")
                )
        );
    }
}
