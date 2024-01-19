package CursoAntigo.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// List é uma coleção que permite a inclusão de elementos duplicados e fornece métodos úteis para adicionar, remover e substituir elementos com base no seu índice.
// Fornece também algoritmos para manipulação de elementos como ordenação (sort), embaralhamento (shuffle), reversão (reverse) e busca binária (binarySearch).
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
        System.out.println("\n--------ordem aleatória-------");
        Collections.shuffle(catsList);
        System.out.println(catsList);
        System.out.println("(\n------ordem natural----");
        Collections.sort(catsList);
        System.out.println(catsList);
        System.out.println("\n------------ordem por idade-----------"); // para esse tipo de ordenação é preciso
                                                                        // utilizar um Comparator

        // Collections.sort(catsList, new ComparatorIdadeGato);
        catsList.sort(new ComparatorIdade()); // ao utilizar a classe de um Comparator, lembrar SEMPRE de intanciá-la
                                              // usando o "new".
        System.out.println(catsList);
        System.out.println("\n------------ordem por cor-----------");
        catsList.sort(new ComparatorCor());
        System.out.println(catsList);
        System.out.println("\n------------ordem por nome-----------"); // mesma coisa que o Collections.sort() faz, mas
                                                                       // dessa vez utilizando um Comparator.
        catsList.sort(new ComparatorNome());
        System.out.println(catsList);
        System.out.println("\n-------ordenar por nome, cor e idade-----------");
        catsList.sort(new ComparatorNomeIdadeCor()); // no método compare(), fazer uma lógica de ordenação que analise
                                                     // todos os critérios para comparação
        System.out.println(catsList);
        System.out.println("utilizando o cinnamon");
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
    public int compareTo(Gato o) { // será utilizado para comparar pelo atributo nome
        return this.getNome().compareToIgnoreCase(o.getNome());
    }

}

class ComparatorIdade implements Comparator<Gato> { // o Comparable e seu método compareTo(), só podem ser implementados
                                                    // uma única vez por classe, por isso é preciso utilizar outras
                                                    // classes com o Comparator e seu método compare() implementados

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