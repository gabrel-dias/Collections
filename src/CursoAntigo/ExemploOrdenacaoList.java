package CursoAntigo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {
        List<Gato> catsList = new ArrayList<>() {
            {
                add(new Gato("patrick", "rosa", 6));
                add(new Gato("bob", "amarelo", 4));
                add(new Gato("molusco", "azul", 8));

            }
        };
        System.out.println("--------ordem de inserção-------");
        System.out.println(catsList);
        System.out.println("");
        System.out.println("--------ordem aleatória-------");
        Collections.shuffle(catsList);
        System.out.println(catsList);
        System.out.println("");
        System.out.println("(------ordem natural----");
        Collections.sort(catsList);
        System.out.println(catsList);

    }

}

class Gato implements Comparable<Gato> {
    private String nome, cor;
    private int idade;

    public Gato(String nome, String cor, int idade) {
        this.nome = nome;
        this.cor = cor;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Gato [nome=" + nome + ", cor=" + cor + ", idade=" + idade + "]";
    }

    @Override
    public int compareTo(Gato o) {
        return this.getNome().compareToIgnoreCase(o.getNome());
    }

}