package br.com.fiap.vertigo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Mapa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MAPA")
    private Long id;
    @Column(name = "NM_MAPA")
    private String nome_mapa;

    public Mapa(Long id, String nome_mapa) {
        this.id = id;
        this.nome_mapa = nome_mapa;
    }
    public Mapa() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_mapa() {
        return nome_mapa;
    }

    public void setNome_mapa(String nome_mapa) {
        this.nome_mapa = nome_mapa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mapa mapa)) return false;
        return Objects.equals(getId(), mapa.getId()) && Objects.equals(getNome_mapa(), mapa.getNome_mapa());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome_mapa());
    }

    @Override
    public String toString() {
        return "Mapa{" +
                "id=" + id +
                ", nome_mapa='" + nome_mapa + '\'' +
                '}';
    }
}
