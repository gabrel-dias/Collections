package cursonovo.exercicios.list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    // criação da lista de números inteiros
    private List<Integer> numerosIntegers;

    // construtor da classe
    public SomaNumeros() {
        this.numerosIntegers = new ArrayList<>();
    }

    // métodos
    public void adicionarNumero(int numero) {
        numerosIntegers.add(numero);
    }

    public int calcularSoma() {
        int resultado = 0;
        for (Integer i : numerosIntegers) {
            resultado += i;
        }
        return resultado;
    }

    /*
     * a grande sacada aqui é atribuir o MENOR valor possível de um número inteiro
     * para que ele seja sempre menor que a comparação feita em relação aos valores
     * contidos na lista dos números
     */
    public int encontrarMaiorNumero() {
        int maiorNumero = Integer.MIN_VALUE;
        if (!numerosIntegers.isEmpty()) {
            for (Integer numero : numerosIntegers) {
                if (numero >= maiorNumero) {
                    maiorNumero = numero;
                }
            }
        }
        return maiorNumero;
    }

    // mesma coisa do método anterior só que ao contrário
    public int encontrarMenorNumero() {
        int menorNumero = Integer.MAX_VALUE;
        if (!numerosIntegers.isEmpty()) {
            for (Integer numero : numerosIntegers) {
                if (numero <= menorNumero) {
                    menorNumero = numero;
                }
            }
        }
        return menorNumero;
    }

    public void exibirNumeros() {
        if (!numerosIntegers.isEmpty()) {
            System.out.println(numerosIntegers);
        }
    }

    public static void main(String[] args) {
        SomaNumeros inteiros = new SomaNumeros();
        inteiros.adicionarNumero(30);
        inteiros.adicionarNumero(10);
        inteiros.adicionarNumero(20);
        System.out.println(inteiros.calcularSoma());
        System.out.println(inteiros.encontrarMaiorNumero());
        System.out.println(inteiros.encontrarMenorNumero());
        inteiros.exibirNumeros();
    }
}
