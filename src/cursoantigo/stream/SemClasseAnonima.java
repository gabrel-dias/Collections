package cursoantigo.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SemClasseAnonima {
    public static void main(String[] args) {
        List<Gato> gatoes = new ArrayList<>(){{
            add(new Gato("gustava", "marrom", 13));
            add(new Gato("felipe", "branco", 14));
            add(new Gato("tomas", "preto", 12));
        }};
       gatoes.sort(new ComparatorIdade()); // sem classe anônima, utiliza a classe ComparatorIdade que implementa
        // o Comparator
        System.out.println(gatoes);
    }
}

class Gato {
    private String nome, cor;
    private int idade;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gato gato = (Gato) o;
        return idade == gato.idade && Objects.equals(nome, gato.nome) && Objects.equals(cor, gato.cor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cor, idade);
    }

    @Override
    public String toString() {
        return "nome = " + nome +", cor = " + cor +
                ", idade = " + idade;
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

    public Gato(String nome, String cor, int idade) {
        this.nome = nome;
        this.cor = cor;
        this.idade = idade;
    }
}

class ComparatorIdade implements Comparator<Gato>{
    @Override
    public int compare(Gato o1, Gato o2) {
        return Integer.compare(o1.getIdade(), o2.getIdade());
    }
}
