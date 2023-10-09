package br.com.fiap.vertigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "partida_times",
            joinColumns = @JoinColumn(name = "ID_PARTIDA"),
            inverseJoinColumns = @JoinColumn(name = "ID_TIME")
    )
    private List<Time> times;

    @ManyToOne
    @JoinColumn(name = "ID_CAMPEONATO")
    private Campeonato nome_campeonato;

    @Column(name = "DT_PARTIDA")
    @FutureOrPresent(message = "A data tem que ser uma data atual ou uma data futura.")
    @NotNull(message = "A data da partida não pode estar vazío.")
    private LocalDateTime data_partida;

}

