package br.com.fiap.vertigo.model;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;

@Entity
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CAMPEONATO")
    private Long id;

    @Column(name = "NM_CAMPEONATO")
    private String nome_campeonato;

    @Column(name = "QT_PARTIDA")
    private int quantidade_partida;

    @OneToMany(mappedBy = "nome_campeonato", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Partida> proximas_partidas;
    
    public Campeonato() { }

    public Campeonato(Long id, String nome_campeonato, int quantidade_partida, List<Partida>proximas_partidas) {
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

    public List<Partida> getProximas_partidas() {
        return proximas_partidas;
    }

    public void setProximas_partidas(List<Partida> proximas_partidas) {
        this.proximas_partidas = proximas_partidas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome_campeonato == null) ? 0 : nome_campeonato.hashCode());
        result = prime * result + quantidade_partida;
        int partidasHash = 0;
        if (proximas_partidas != null) {
            for (Partida partida : proximas_partidas) {
                if (partida != null && partida.getId() != null) {
                    partidasHash += partida.getId().hashCode();
                }
            }
        }
        result = prime * result + partidasHash;

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
        if (proximas_partidas == null) {
            if (other.proximas_partidas != null)
                return false;
        } else if (!proximas_partidas.equals(other.proximas_partidas))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Campeonato [id=" + id + ", nome_campeonato=" + nome_campeonato +
                ", quantidade_partida=" + quantidade_partida +
                ", proximas_partidas=" + proximas_partidas + "]";
    }
}
