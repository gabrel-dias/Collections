package main.java.MeusExercícios.list.ordenação;

import java.util.Comparator;

public class Pessoa implements Comparable<Pessoa> {
    private String nome;
    private int idade;
    private double altura;

    // construtor de pessoas
    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    // utilizado o método compare() da classe Integer, com os parâmetros da idade
    // que vêm do atributo e do objeto
    @Override
    public int compareTo(Pessoa p) {
        return Integer.compare(idade, p.getIdade());
    }

    /*
     * também é possível utilizar esse mesmo método mas com um retorno diferente,
     * note que nesse caso o método compare() não é utilizado. Ao invés disso, é
     * feito uma subtração entre o valor do atributo e valor que será passado no
     * parâmetro com o objeto
     */
    // @Override
    // public int compareTo(Pessoa p) {
    // return this.idade - p.idade;
    // }
    // TODO com a implementação da Comparable, só é possível utilizar um compareTo()
    // por vez

    public String getNome() { // acessores
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", idade=" + idade + ", altura=" + altura + "]";
    }

}

// classe implementando a interface Comparator<>
// que só pode ser utilizado em uma classe própria, só para essa finalidade
class ComparatorAltura implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return Double.compare(p1.getAltura(), p2.getAltura());
    }
}