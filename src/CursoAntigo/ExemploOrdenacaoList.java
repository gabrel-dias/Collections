package CursoAntigo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExemploOrdenacaoList {
    public static void main(String[] args) {
        List<Gato> catsList = new ArrayList<>() {
            {
                add(new Gato("patrick", "rosa", 6));
                add(new Gato("bob", "amarelo", 4));
                add(new Gato("molusco", "azul", 8));
                add(new Gato("patrick", "rosa", 7));

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
        System.out.println("");
        System.out.println("------------ordem por idade-----------");
        // Collections.sort(catsList, new ComparatorIdadeGato); também é possível
        // ordenar por esse método, mas
        // é preciso passar uma List e um Comparator, que deve ser criado em uma classe
        // separada. Caso optar pela Collections, o compilador avisará que existe (ou
        // não) o mesmo método sendo utilizado.
        catsList.sort(new ComparatorIdade()); // ao utilizar a classe criada do Comparator, lembrar sempre de intanciar
                                              // usando o "new".
        System.out.println(catsList);
        System.out.println("");
        System.out.println("------------ordem por cor-----------");
        catsList.sort(new ComparatorCor());
        System.out.println(catsList);
        System.out.println("");
        System.out.println("------------ordem por nome-----------"); // mesma coisa que o Collections.sort() faz, mas
                                                                     // dessa vez utilizando um Comparator.
        catsList.sort(new ComparatorNome());
        System.out.println(catsList);
        System.out.println("");
        System.out.println("-------ordenar por nome, cor e idade-----------");
        catsList.sort(new ComparatorNomeIdadeCor());
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

class ComparatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }

}

class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }

}

class ComparatorNome implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getNome().compareTo(g2.getNome());
    }

}

class ComparatorNomeIdadeCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        /*
         * para entender essa lógica, é importante saber disso:
         * se os objetos forem IGUAIS, o método retornará o número 0;
         * se o primeiro objeto é MENOR que o segundo objeto, retornará um valor
         * negativo;
         * se o primeiro objeto é MAIOR que o segundo objeto, retornará um valor
         * postivo.
         */
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0)
            return nome; // se os nomes forem diferentes, o critério de ordenação será por nomes, visto
                         // que, se o retorno for um valor diferente de '0', significa que algum dos
                         // objetos é diferente.
        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0)
            return cor; // a mesma lógica se aplica aqui.

        return Integer.compare(g1.getIdade(), g2.getIdade()); // caso os todos os critérios sejam iguais, o critério
                                                              // da idade será utilizado para fazer a ordenação.
    }

}