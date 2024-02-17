package cursonovo.exercicios.list.basicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    // atributo
    private List<Item> comprasCarrinho;

    // método construtor
    public CarrinhoCompras() {
        this.comprasCarrinho = new ArrayList<>();
    }

    // métodos
    public void adionarItem(String nome, double preco, int quantidade) {
        Item item = new Item(nome, preco, quantidade);
        this.comprasCarrinho.add(item);
    }

    public void removerItem(String nome) {
        List<Item> itemRemover = new ArrayList<>();
        if (!comprasCarrinho.isEmpty()) {
            for (Item i : comprasCarrinho) {
                if (i.getNome().equalsIgnoreCase(nome)) {
                    itemRemover.add(i);
                }
            }
            comprasCarrinho.removeAll(itemRemover);
        } else {
            System.out.println("Tá vazia!");
        }
    }

    public double calcularValorTotal() {
        double valorTotal = 0d;
        if (!comprasCarrinho.isEmpty()) {
            for (Item item : comprasCarrinho) {
                double valorItem = item.getPreco() * item.getQuantidade();
                valorTotal += valorItem;
            }
            return valorTotal;
        } else {
            throw new RuntimeException("A lista está vazia");
        }
    }

    public void exibirItens() {
    if (!comprasCarrinho.isEmpty()){
        System.out.println(this.comprasCarrinho);
    } else {
        System.out.println("Está vazia!");
    }
    }

    

    public static void main(String[] args) {
        CarrinhoCompras carrin = new CarrinhoCompras();
        carrin.adionarItem("pepino", 100d, 2);
        carrin.adionarItem("tomate", 200d, 1);
        carrin.adionarItem("banana", 500d, 13);
        carrin.adionarItem("melancia", 50d, 69);
        
        carrin.exibirItens();
        carrin.removerItem("melancia");
        carrin.exibirItens();
        System.out.println("Valor total = " + carrin.calcularValorTotal());
        

    }
}
