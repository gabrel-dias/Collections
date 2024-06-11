package cursonovo.set.Ordenacao;

import java.util.HashSet;
import java.util.Set;

public class CadastroProdutos {
    private Set<Produto> produtoSet;

    public CadastroProdutos() {
        this.produtoSet = new HashSet<>();
    }

    public void adicionarProduto(String nome, long codigo, double preco, int quantidade){
        produtoSet.add(new Produto(nome,codigo,preco,quantidade));
    }
}
