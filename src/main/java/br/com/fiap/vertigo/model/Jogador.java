package br.com.fiap.vertigo.model;

public class Jogador {
    private String nome_jogador;
    private int numero_partida;
    private int kill;
    private int death;
    private Time time;
    
    public Jogador() { }

    public Jogador(String nome_jogador, int numero_partida, int kill, int death, Time time) {
        this.nome_jogador = nome_jogador;
        this.numero_partida = numero_partida;
        this.kill = kill;
        this.death = death;
        this.time = time;
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome_jogador == null) ? 0 : nome_jogador.hashCode());
        result = prime * result + numero_partida;
        result = prime * result + kill;
        result = prime * result + death;
        result = prime * result + ((time == null) ? 0 : time.hashCode());
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
        Jogador other = (Jogador) obj;
        if (nome_jogador == null) {
            if (other.nome_jogador != null)
                return false;
        } else if (!nome_jogador.equals(other.nome_jogador))
            return false;
        if (numero_partida != other.numero_partida)
            return false;
        if (kill != other.kill)
            return false;
        if (death != other.death)
            return false;
        if (time == null) {
            if (other.time != null)
                return false;
        } else if (!time.equals(other.time))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Jogador [nome_jogador=" + nome_jogador + ", numero_partida=" + numero_partida + ", kill=" + kill
                + ", death=" + death + ", time=" + time + "]";
    }
}
