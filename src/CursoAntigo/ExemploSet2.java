package CursoAntigo;

import java.util.HashSet;
import java.util.Set;

public class ExemploSet2 {
  public static void main(String[] args) {
    System.out.println("Ordem de séries aleatória...");
    Set<Serie> seriesHashSet = new HashSet<>(){{
        add(new Serie("got", "fantasia", 60));
        add(new Serie("dark", "drama", 60));
        add(new Serie("friends", "comédia", 24));
    }};
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
    


}