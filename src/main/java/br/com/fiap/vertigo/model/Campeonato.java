package br.com.fiap.vertigo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Arrays;

@Entity
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome_campeonato;
    private int quantidade_partida;
    private Partida[] proximas_partidas;
    
    public Campeonato() { }

    public Campeonato(Long id, String nome_campeonato, int quantidade_partida, Partida[] proximas_partidas) {
        this.id = id;
        this.nome_campeonato = nome_campeonato;
        this.quantidade_partida = quantidade_partida;
        this.proximas_partidas = proximas_partidas;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getNome_campeonato() {
        return nome_campeonato;
    }

    public void setNome_campeonato(String nome_campeonato) {
        this.nome_campeonato = nome_campeonato;
    }

    public int getQuantidade_partida() {
        return quantidade_partida;
    }

    public void setQuantidade_partida(int quantidade_partida) {
        this.quantidade_partida = quantidade_partida;
    }

    public Partida[] getProximas_partidas() {
        return proximas_partidas;
    }

    public void setProximas_partidas(Partida[] proximas_partidas) {
        this.proximas_partidas = proximas_partidas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome_campeonato == null) ? 0 : nome_campeonato.hashCode());
        result = prime * result + quantidade_partida;
        result = prime * result + Arrays.hashCode(proximas_partidas);
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
        Campeonato other = (Campeonato) obj;
        if (id != other.id)
            return false;
        if (nome_campeonato == null) {
            if (other.nome_campeonato != null)
                return false;
        } else if (!nome_campeonato.equals(other.nome_campeonato))
            return false;
        if (quantidade_partida != other.quantidade_partida)
            return false;
        if (!Arrays.equals(proximas_partidas, other.proximas_partidas))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Campeonato [id=" + id + ", nome_campeonato=" + nome_campeonato +
                ", quantidade_partida=" + quantidade_partida +
                ", proximas_partidas=" + Arrays.toString(proximas_partidas) + "]";
    }
}
