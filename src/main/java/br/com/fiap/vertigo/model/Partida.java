package br.com.fiap.vertigo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;


@Entity
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Time time;
    @ManyToOne
    private Campeonato nome_campeonato;

    private LocalDateTime data_partida;

    private int mortes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_MAPA")
    private Mapa mapa;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getTime() {return time;}

    public void setTime(Time time) {
        this.time = time;
    }

    public LocalDateTime getData_partida() {
        return data_partida;
    }

    public void setData_partida(LocalDateTime data_partida) {
        this.data_partida = data_partida;
    }

    public Campeonato getNome_campeonato() {
        return nome_campeonato;
    }

    public void setNome_campeonato(Campeonato nome_campeonato) {
        this.nome_campeonato = nome_campeonato;
    }

    public int getMortes() {
        return mortes;
    }

    public void setMortes(int mortes) {
        this.mortes = mortes;
    }

    public Mapa getMapa() {
        return mapa;
    }

    public void setMapa(Mapa mapa) {
        this.mapa = mapa;
    }

    public Partida() {}

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Partida other = (Partida) obj;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.getId().equals(other.time.getId())) {
            return false;
        }
        if (data_partida == null) {
            if (other.data_partida != null)
                return false;
        } else if (!data_partida.equals(other.data_partida))
            return false;
        if (nome_campeonato == null) {
            if (other.nome_campeonato != null)
                return false;
        } else if (!nome_campeonato.equals(other.nome_campeonato))
            return false;
        if (mortes != other.mortes)
            return false;
        if (mapa == null) {
            if (other.mapa != null)
                return false;
        } else if (!mapa.equals(other.mapa))
            return false;
        if (id != other.id)
            return false;
        return true;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, time, data_partida, nome_campeonato, mortes, mapa);
    }

    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id +
                ", time=" + time +
                ", data_partida=" + data_partida +
                ", nome_campeonato=" + nome_campeonato +
                ", mortes=" + mortes +
                ", mapa=" + mapa +
                '}';
    }

}

