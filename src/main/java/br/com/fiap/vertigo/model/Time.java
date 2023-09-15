package br.com.fiap.vertigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private int vitorias;
    @NotBlank
    private int derrotas;
    @NotBlank
    private int empates;
    @NotBlank
    private String imagem;
    @NotBlank
    private String nome;
}
