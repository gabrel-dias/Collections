package exercícios.list.ordenação;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    // atributo
    private List<Pessoa> pessoaList;

    // construtor
    public OrdenacaoPessoas() {
        this.pessoaList = new ArrayList<>();
    }

    // métodos
    public void adicionarPessoa(String nome, int idade, double altura) {
        pessoaList.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordenarPorIdade() {
        Collections.sort(pessoaList);
        return pessoaList;
    }

    public List<Pessoa> ordenarPorAltura() {
        Collections.sort(pessoaList, new ComparatorAltura());
        return pessoaList;
    }

    public static void main(String[] args) {
        OrdenacaoPessoas pessoinhas = new OrdenacaoPessoas();

        pessoinhas.adicionarPessoa("gabriel", 24, 1.69);
        pessoinhas.adicionarPessoa("pedro", 16, 1.72);
        pessoinhas.adicionarPessoa("bruna", 23, 1.59);
        System.out.println(pessoinhas.ordenarPorIdade());
        System.out.println(pessoinhas.ordenarPorAltura());
    }
}