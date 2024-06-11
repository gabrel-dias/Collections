package cursonovo.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;
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
        produtoSet.addAll(produtoSet);
        return produtosPreco;
}}
