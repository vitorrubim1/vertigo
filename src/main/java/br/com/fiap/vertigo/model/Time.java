package br.com.fiap.vertigo.model;

import java.util.Objects;

public class Time {
    private Long id;
    private int vitorias;
    private int derrotas;
    private int empates;
    private String imagem;
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
