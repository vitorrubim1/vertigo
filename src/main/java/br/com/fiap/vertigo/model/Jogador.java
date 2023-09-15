package br.com.fiap.vertigo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Jogador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome_jogador;

    private int numero_partida;

    private int kill;

    private int death;

    private int time_id;

    public Jogador() {
    }

    public Jogador(Long id, String nome_jogador, int numero_partida, int kill, int death, int time_id) {
        this.id = id;
        this.nome_jogador = nome_jogador;
        this.numero_partida = numero_partida;
        this.kill = kill;
        this.death = death;
        this.time_id = time_id;
    }

    public Long getId() {
        return id;
    }

    public Jogador setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome_jogador() {
        return nome_jogador;
    }

    public Jogador setNome_jogador(String nome_jogador) {
        this.nome_jogador = nome_jogador;
        return this;
    }

    public int getNumero_partida() {
        return numero_partida;
    }

    public Jogador setNumero_partida(int numero_partida) {
        this.numero_partida = numero_partida;
        return this;
    }

    public int getKill() {
        return kill;
    }

    public Jogador setKill(int kill) {
        this.kill = kill;
        return this;
    }

    public int getDeath() {
        return death;
    }

    public Jogador setDeath(int death) {
        this.death = death;
        return this;
    }

    public int getTime_id() {
        return time_id;
    }

    public Jogador setTime_id(int time_id) {
        this.time_id = time_id;
        return this;
    }
}
