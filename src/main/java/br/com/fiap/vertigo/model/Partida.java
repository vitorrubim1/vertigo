package br.com.fiap.vertigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @NotBlank
//    private Time time;
//    @NotBlank
//    private Campeonato nome_campeonato;
    @NotBlank
    private LocalDateTime data_partida;
    @NotBlank
    private int mortes;
//    @NotBlank
//    private Mapa mapa;
}

