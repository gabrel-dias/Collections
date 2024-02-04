package cursoantigo.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ExemploMap2 {
    public static void main(String[] args) {
        Map<String, Livro> livrosAleatorios = new HashMap<>() { // também é possível utilizar uma classe como valor pro
                                                                // Map
            {
                put("George R.R. Martin", new Livro("A Tormenta de Espadas", 832));
                put("Stephen King", new Livro("IT: A Coisa", 1104));
                put("J.K. Rowling", new Livro("Harry Potter e a Pedra Filosofal", 208));
            }
        };

        System.out.println("--\t Ordem aleatória \t--");
        for (Map.Entry<String, Livro> livro : livrosAleatorios.entrySet()) {
            System.out.println(livro.getKey() + "\n" + livro.getValue().getTitulo()); // o getter do título vem do
                                                                                      // atributo da classe 'Livro'
        }

        System.out.println("--\t Ordem de inserção \t --");
        Map<String, Livro> livrosInseridos = new LinkedHashMap<>() {
            {
                put("Stephen King", new Livro("IT: A coisa", 1104));
                put("J.K. Rowling", new Livro("Harry Potter e a Pedra Filosofal", 208));
                put("George R.R. Martin", new Livro("A Tormenta de Espadas", 832));
            }
        };
        for (Map.Entry<String, Livro> livro : livrosInseridos.entrySet()) {
            System.out.println(livro.getKey() + "\n" + livro.getValue().getTitulo());
        }

        System.out.println("--\t Ordem de autores \t--");
        Map<String, Livro> livrosAutores = new TreeMap<>(livrosAleatorios); // o TreeMap constrói um novo Map com os
                                                                            // elementos ordenados de acordo com ordem
                                                                            // natural das suas CHAVES
        for (Map.Entry<String, Livro> livro : livrosAutores.entrySet()) {
            System.out.println(livro.getKey() + "\n" + livro.getValue().getTitulo());
        }

        System.out.println("--\t Ordem alfabética dos livros \t--");
        Set<Map.Entry<String, Livro>> livroSet = new TreeSet<>(new ComparatorLivros()); // para ordenar os valores é
        // preciso utilizar o Comparator

        livroSet.addAll(livrosAleatorios.entrySet());// é preciso utilizar o entrySet() com o addAll para que todos os
        // elementos do
        // Map sejam repassados para o Set
        for (Map.Entry<String, Livro> livro : livroSet) {
            System.out.println(livro.getKey() + "\n" + livro.getValue().getTitulo());
        }

        System.out.println("--\t Ordem número de página \t--");
        Set<Map.Entry<String, Livro>> paginaSet = new TreeSet<>(new ComparatorPaginas());
        paginaSet.addAll(livrosAleatorios.entrySet());
        for (Entry<String, Livro> livro : paginaSet) {
            System.out.println(
                    livro.getValue().getTitulo() + "\n" + livro.getValue().getQuantidadePaginas() + " páginas");
        }
       
        // TODO estudar mais esses últimos exemplos com o Comparator e a Entry no geral
    }

}

class Livro {
    private String titulo;
    private int quantidadePaginas;

    public String getTitulo() {
        return titulo;
    }

    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public Livro(String titulo, int quantidadePaginas) {
        this.titulo = titulo;
        this.quantidadePaginas = quantidadePaginas;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        result = prime * result + quantidadePaginas;
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
        Livro other = (Livro) obj;
        if (titulo == null) {
            if (other.titulo != null)
                return false;
        } else if (!titulo.equals(other.titulo))
            return false;
        if (quantidadePaginas != other.quantidadePaginas)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Título - " + titulo + ", Páginas - " + quantidadePaginas;
    }

}

class ComparatorLivros implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Entry<String, Livro> o1, Entry<String, Livro> o2) {
        return o1.getValue().getTitulo().compareToIgnoreCase(o2.getValue().getTitulo()); // primeiro é utilizado o
                                                                                         // getValue() para acessar o
                                                                                         // valor da Entry, que é a
                                                                                         // classe 'Livro'. Depois é
                                                                                         // utilizado o getter do
                                                                                         // atributo que está na classe
                                                                                         // e que será utilizado
                                                                                         // para fazer a comparação
    }

}

class ComparatorPaginas implements Comparator<Map.Entry<String, Livro>> {

    @Override
    public int compare(Entry<String, Livro> o1, Entry<String, Livro> o2) {
        return o1.getValue().getQuantidadePaginas() - o2.getValue().getQuantidadePaginas();
    }

}