package cursonovo.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(String nome, long codigo, double preco, int quantidade) {
        produtoSet.add(new Produto(nome, codigo, preco, quantidade));
    }

    public Set<Produto> exibirProdutosNome() {
        Set<Produto> produtosNome = new TreeSet<>(produtoSet);
        return produtosNome;
    }

    public Set<Produto> exibirProdutosPreco() {
        Set<Produto> produtosPreco = new TreeSet<>(new ComparatorPreco());
        produtosPreco.addAll(produtoSet);
        return produtosPreco;
    }

    public static void main(String[] args) {
        CadastroProdutos cadastro = new CadastroProdutos();

        cadastro.adicionarProduto("tomate", 12, 1.50, 2);
        cadastro.adicionarProduto("banana", 112, 1.20, 6);
        cadastro.adicionarProduto("melancia", 13, 5.30, 4);
        cadastro.adicionarProduto("batata", 14, 3d, 5);
        System.out.println(cadastro.exibirProdutosNome());
        System.out.println(cadastro.exibirProdutosPreco());
    }
}
