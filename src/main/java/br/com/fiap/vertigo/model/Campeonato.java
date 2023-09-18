package br.com.fiap.vertigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


import java.util.List;
import java.util.Objects;

@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Campeonato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CAMPEONATO")
    private Long id;

    @Column(name = "NM_CAMPEONATO")
    @NotBlank
    private String nome_campeonato;

    @OneToMany(mappedBy = "nome_campeonato", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Partida> proximas_partidas;

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getNome_campeonato() {
        return nome_campeonato;
    }

    public void setNome_campeonato(String nome_campeonato) {
        this.nome_campeonato = nome_campeonato;
    }

    
    public List<Partida> getProximas_partidas() {
        return proximas_partidas;
    }

    public void setProximas_partidas(List<Partida> proximas_partidas) {
        this.proximas_partidas = proximas_partidas;
    }

    @Override
    public String toString() {
        return "Campeonato{" +
               "id=" + id +
               ", nome_campeonato='" + nome_campeonato + '\'' +
               ", proximas_partidas=" + proximas_partidas +
               '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Campeonato other = (Campeonato) obj;
            return Objects.equals(id, other.id) &&
            Objects.equals(nome_campeonato, other.nome_campeonato) &&
            Objects.equals(proximas_partidas, other.proximas_partidas);
        }

    @Override
    public int hashCode() {
            return Objects.hash(id, nome_campeonato, proximas_partidas);
        }
}
