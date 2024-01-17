package CursoAntigo.Set;

import java.util.HashSet;
import java.util.Set;

public class ExemploSet2 {
    public static void main(String[] args) {
        System.out.println("Ordem de séries aleatória...");
        Set<Serie> seriesHashSet = new HashSet<>() {
            {
                add(new Serie("got", "fantasia", 60));
                add(new Serie("dark", "drama", 60));
                add(new Serie("friends", "comédia", 24));
            }
        };
        System.out.println(seriesHashSet);
    }
}

class Serie {
    private String nome;
    private String genero;
    private int tempoEp;

    public Serie(String nome, String genero, int tempoEp) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEp = tempoEp;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public int getTempoEp() {
        return tempoEp;
    }

    @Override
    public String toString() {
        return "[nome=" + nome + ", genero=" + genero + ", tempoEp=" + tempoEp + "]";
    }

    // a IDE criou e não sei nada disso ainda
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + ((genero == null) ? 0 : genero.hashCode());
        result = prime * result + tempoEp;
        return result;
    }

    // também não sei
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Serie other = (Serie) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (genero == null) {
            if (other.genero != null)
                return false;
        } else if (!genero.equals(other.genero))
            return false;
        if (tempoEp != other.tempoEp)
            return false;
        return true;
    }

}