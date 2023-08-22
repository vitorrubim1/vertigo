package br.com.fiap.vertigo.model;

import java.time.LocalDateTime;
import java.util.Arrays;

public class Partida {
    private Time[] time;
    private LocalDateTime data_partida;
    private Campeonato nome_campeonato;
    private int mortes;
    private Mapa mapa;
    
    
    public Partida() {}

     public Time[] getTime() {
        return time;
    }

    public void setTime(Time[] time) {
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

    public Partida(Time[] time, LocalDateTime data_partida, Campeonato nome_campeonato, int mortes, Mapa mapa) {
        this.time = time;
        this.data_partida = data_partida;
        this.nome_campeonato = nome_campeonato;
        this.mortes = mortes;
        this.mapa = mapa;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(time);
        result = prime * result + ((data_partida == null) ? 0 : data_partida.hashCode());
        result = prime * result + ((nome_campeonato == null) ? 0 : nome_campeonato.hashCode());
        result = prime * result + mortes;
        result = prime * result + ((mapa == null) ? 0 : mapa.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Partida other = (Partida) obj;
        if (!Arrays.equals(time, other.time))
            return false;
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
        return true;
    }

    @Override
    public String toString() {
        return "Partida [time=" + Arrays.toString(time) + ", data_partida=" + data_partida + ", nome_campeonato="
                + nome_campeonato + ", mortes=" + mortes + ", mapa=" + mapa + "]";
    }
}


