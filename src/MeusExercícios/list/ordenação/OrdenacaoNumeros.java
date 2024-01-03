package main.java.MeusExercícios.list.ordenação;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoNumeros {

    private List<Integer> numeroList;

    public OrdenacaoNumeros() {
        this.numeroList = new ArrayList<>();
    }

    public void adicionarNumero(int numero) {
        numeroList.add(numero);
    }

    public List<Integer> ordenarAscendente() {
        List<Integer> numerosAscendentes = new ArrayList<>(numeroList);
        Collections.sort(numerosAscendentes);
        return numerosAscendentes;
    }

    public List<Integer> ordenarDescendente() {
        numeroList.sort(Collections.reverseOrder());
        return numeroList;
    }

    public static void main(String[] args) {
        OrdenacaoNumeros ordenados = new OrdenacaoNumeros();
        ordenados.adicionarNumero(10);
        ordenados.adicionarNumero(1);
        ordenados.adicionarNumero(69);
        ordenados.adicionarNumero(66);
        System.out.println(ordenados.ordenarAscendente());
        System.out.println(ordenados.ordenarDescendente());

    }

}