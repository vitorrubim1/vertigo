package br.com.fiap.vertigo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String nome_jogador;
    private int numero_partida;
    private int kill;
    private int death;
    private Long time;

    public Jogador() {
    }

    public Jogador(Long id, String nome_jogador, int numero_partida, int kill, int death, Long time) {
        this.id = id;
        this.nome_jogador = nome_jogador;
        this.numero_partida = numero_partida;
        this.kill = kill;
        this.death = death;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_jogador() {
        return nome_jogador;
    }

    public void setNome_jogador(String nome_jogador) {
        this.nome_jogador = nome_jogador;
    }

    public int getNumero_partida() {
        return numero_partida;
    }

    public void setNumero_partida(int numero_partida) {
        this.numero_partida = numero_partida;
    }

    public int getKill() {
        return kill;
    }

    public void setKill(int kill) {
        this.kill = kill;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jogador jogador)) return false;
        return getNumero_partida() == jogador.getNumero_partida() && getKill() == jogador.getKill() && getDeath() == jogador.getDeath() && Objects.equals(getId(), jogador.getId()) && Objects.equals(getNome_jogador(), jogador.getNome_jogador()) && Objects.equals(getTime(), jogador.getTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome_jogador(), getNumero_partida(), getKill(), getDeath(), getTime());
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "id=" + id +
                ", nome_jogador='" + nome_jogador + '\'' +
                ", numero_partida=" + numero_partida +
                ", kill=" + kill +
                ", death=" + death +
                ", time=" + time +
                '}';
    }
}
