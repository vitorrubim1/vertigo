package br.com.fiap.vertigo.model;

public class Time {
    private int vitorias;
    private int derrotas;
    private int empates;
    private String imagem;
    private String nome;
    
    public Time() { }

    public Time(int vitorias, int derrotas, int empates, String imagem, String nome) {
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
        this.imagem = imagem;
        this.nome = nome;
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + vitorias;
        result = prime * result + derrotas;
        result = prime * result + empates;
        result = prime * result + ((imagem == null) ? 0 : imagem.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
        Time other = (Time) obj;
        if (vitorias != other.vitorias)
            return false;
        if (derrotas != other.derrotas)
            return false;
        if (empates != other.empates)
            return false;
        if (imagem == null) {
            if (other.imagem != null)
                return false;
        } else if (!imagem.equals(other.imagem))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Time [vitorias=" + vitorias + ", derrotas=" + derrotas + ", empates=" + empates + ", imagem=" + imagem
                + ", nome=" + nome + "]";
    }
}
