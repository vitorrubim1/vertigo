package br.com.fiap.vertigo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @NotBlank(message = "O nome do campeonato não pode estar vazío.")
    private String nome_campeonato;

}
