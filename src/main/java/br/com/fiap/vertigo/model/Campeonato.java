package br.com.fiap.vertigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CAMPEONATO")
    private Long id;

    @Column(name = "NM_CAMPEONATO")
    @NotBlank
    private String nome_campeonato;

    @NotNull
    @ElementCollection
    @Column(name = "PROXIMAS_PARTIDAS")
    private List<Long> proximas_partidas;
}
