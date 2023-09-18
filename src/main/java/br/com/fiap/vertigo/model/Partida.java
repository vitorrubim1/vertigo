package br.com.fiap.vertigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_TIME")
    private Time time;

    @ManyToOne
    @JoinColumn(name = "ID_CAMPEONATO")
    private Campeonato nome_campeonato;

    @Column(name = "DT_PARTIDA")
    @FutureOrPresent
    @NotNull
    private LocalDateTime data_partida;

    public Long getId() {
        return id;
    }

    public Partida setId(Long id) {
        this.id = id;
        return this;
    }

    public Time getTime() {
        return time;
    }

    public Partida setTime(Time time) {
        this.time = time;
        return this;
    }

    public Campeonato getNome_campeonato() {
        return nome_campeonato;
    }

    public Partida setNome_campeonato(Campeonato nome_campeonato) {
        this.nome_campeonato = nome_campeonato;
        return this;
    }

    public LocalDateTime getData_partida() {
        return data_partida;
    }

    public Partida setData_partida(LocalDateTime data_partida) {
        this.data_partida = data_partida;
        return this;
    }
    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id +
                ", time=" + time +
                ", nome_campeonato=" + nome_campeonato +
                ", data_partida=" + data_partida +
                '}';
    }


}

