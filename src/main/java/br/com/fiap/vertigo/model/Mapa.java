package br.com.fiap.vertigo.model;

public class Mapa {
    private String nome_mapa;

    public Mapa() { }

    public Mapa(String nome_mapa) {
        this.nome_mapa = nome_mapa;
    }

    public String getNome_mapa() {
        return nome_mapa;
    }

    public void setNome_mapa(String nome_mapa) {
        this.nome_mapa = nome_mapa;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome_mapa == null) ? 0 : nome_mapa.hashCode());
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
        Mapa other = (Mapa) obj;
        if (nome_mapa == null) {
            if (other.nome_mapa != null)
                return false;
        } else if (!nome_mapa.equals(other.nome_mapa))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Mapa [nome_mapa=" + nome_mapa + "]";
    }
}
