package br.com.fiap.vertigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome_jogador;
    @NotBlank
    private int numero_partida;
    @NotBlank
    private int kill;
    @NotBlank
    private int death;
    @NotBlank
    private int time_id;
}
