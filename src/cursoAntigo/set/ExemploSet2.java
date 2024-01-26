package cursoantigo.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSet2 {
    public static void main(String[] args) {
        System.out.println("Ordem aleatória...");
        Set<Serie> seriesHashSet = new HashSet<>() { // HashSet gera uma ordem aleatória dos elementos do conjunto, mas possui um eficiente desempenho de busca 
            {
                add(new Serie("got", "fantasia", 60));
                add(new Serie("dark", "drama", 60));
                add(new Serie("friends", "comédia", 24));
            }
        };
        for (Serie serie : seriesHashSet) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEp());
        }

        System.out.println("\nOrdem de inserção...");
        Set<Serie> seriesLinkedHashSet = new LinkedHashSet<>() { // LinkedHashSet suporta usar a ordem de inserção e também tem um bom desempenho de busca
            {
                add(new Serie("got", "fantasia", 60));
                add(new Serie("dark", "drama", 60));
                add(new Serie("friends", "comédia", 24));
            }
        };
        for (Serie serie : seriesLinkedHashSet) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEp());

        }

        System.out.println("\nOrdem natural (tempoEp)...");
        Set<Serie> seriesTreeSet = new TreeSet<>() { // TreeSet mantém os elementos armazenados automaticamente em ordem crescente
            {
                add(new Serie("got", "fantasia", 60));
                add(new Serie("dark", "drama", 60));
                add(new Serie("friends", "comédia", 24));

            }
        };
        for (Serie serie : seriesTreeSet) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEp());
        }

        System.out.println("\nComparar por nome/genero/tempoEp...");
        Set<Serie> seriesComparator = new TreeSet<>(new ComparatorNomeGeneroTempo());
        seriesComparator.addAll(seriesHashSet);
        for (Serie serie : seriesTreeSet) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEp());
        }

        System.out.println("\nOrdenar por gênero...");
        Set<Serie> generoSeries = new TreeSet<>(new ComparatorGenero()) { // além de implementar o Set, é preciso
                                                                          // implementar o construtor da classe que
                                                                          // contenha o método Comparator e seu método
                                                                          // implementado
            {
                add(new Serie("american horror story", "terror", 42)); // adicionando mais séries ao conjunto para
                                                                       // facilitar a visibilidade da ordenação
                add(new Serie("cuphead", "animação", 24));
                add(new Serie("sherlock", "policial", 60));
            }
        };
        generoSeries.addAll(seriesHashSet);
        for (Serie serie : generoSeries) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEp());
        }
    }
}

class Serie implements Comparable<Serie> {
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

    @Override
    public int compareTo(Serie o) {
        int tempoEp = Integer.compare(this.getTempoEp(), o.getTempoEp()); // variável que recebe a diferença entre o
                                                                          // atributo e o objeto

        if (tempoEp != 0) // se o resultado for diferente !=0, retornará o valor da variável que será
                          // usado para comparar
            return tempoEp;

        return this.getGenero().compareTo(o.getGenero());
    }

}

class ComparatorNomeGeneroTempo implements Comparator<Serie> {

    @Override
    public int compare(Serie o1, Serie o2) {
        int nome = o1.getNome().compareTo(o2.getNome()); // primeiro compara se os nomes são diferentes
        if (nome != 0)
            return nome;

        int genero = o1.getNome().compareTo(o2.getNome()); // compara se os gêneros são diferentes
        if (nome != 0)
            return genero;

        return Integer.compare(o1.getTempoEp(), o2.getTempoEp()); // caso os dois sejam iguais, é comparado por tempoEp
    }

}

class ComparatorGenero implements Comparator<Serie> {

    @Override
    public int compare(Serie o1, Serie o2) {
        return o1.getGenero().compareToIgnoreCase(o2.getGenero());
    }

}