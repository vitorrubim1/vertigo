package br.com.fiap.vertigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @PositiveOrZero(message = "As vitórias precisa ter um número maior ou igual a zero")
    private int vitorias;

    @NotNull
    @PositiveOrZero(message = "As derrotas precisa ter um número maior ou igual a zero")
    private int derrotas;

    @NotBlank(message = "O imagem do time não pode estar vazío.")
    private String imagem;

    @NotBlank(message = "O nome do time não pode estar vazío.")
    private String nome;
}
