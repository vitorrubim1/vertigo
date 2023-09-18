package br.com.fiap.vertigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private int vitorias;
    @NotNull
    private int derrotas;
    @NotBlank
    private String imagem;
    @NotBlank
    private String nome;

    public Long getId() {
        return id;
    }

    public Time setId(Long id) {
        this.id = id;
        return this;
    }

    public int getVitorias() {
        return vitorias;
    }

    public Time setVitorias(int vitorias) {
        this.vitorias = vitorias;
        return this;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public Time setDerrotas(int derrotas) {
        this.derrotas = derrotas;
        return this;
    }

    public String getImagem() {
        return imagem;
    }

    public Time setImagem(String imagem) {
        this.imagem = imagem;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Time setNome(String nome) {
        this.nome = nome;
        return this;
    }
    @Override
    public String toString() {
        return "Time{" +
                "id=" + id +
                ", vitorias=" + vitorias +
                ", derrotas=" + derrotas +
                ", imagem='" + imagem + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}
