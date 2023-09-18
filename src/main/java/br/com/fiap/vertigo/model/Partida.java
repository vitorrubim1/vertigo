package br.com.fiap.vertigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_TIME")
    private Time[] time;

    @ManyToOne
    @JoinColumn(name = "ID_CAMPEONATO")
    private Campeonato nome_campeonato;

    @Column(name = "DT_PARTIDA")
    @FutureOrPresent
    @NotNull
    private LocalDateTime data_partida;
}

