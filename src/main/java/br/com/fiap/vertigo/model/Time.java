package br.com.fiap.vertigo.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIME")
    private Long id;

    @Column(name = "VITORIAS_TIME")
    private int vitorias;

    @Column(name = "DERROTAS_TIME")
    private int derrotas;

    @Column(name = "EMPATES_TIME")
    private int empates;

    @Column(name = "IMAGEM_TIME")
    private String imagem;

    @Column(name = "NM_TIME")
    private String nome;

    public Time(Long id, int vitorias, int derrotas, int empates, String imagem, String nome) {
        this.id = id;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
        this.imagem = imagem;
        this.nome = nome;
    }

    public Time() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Time time)) return false;
        return getVitorias() == time.getVitorias() && getDerrotas() == time.getDerrotas() && getEmpates() == time.getEmpates() && Objects.equals(getId(), time.getId()) && Objects.equals(getImagem(), time.getImagem()) && Objects.equals(getNome(), time.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getVitorias(), getDerrotas(), getEmpates(), getImagem(), getNome());
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", vitorias=" + vitorias +
                ", derrotas=" + derrotas +
                ", empates=" + empates +
                ", imagem='" + imagem + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
