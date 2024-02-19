package cursoantigo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExemploStreamAPI {
    /*
     * as streams possuem dois tipos de operações: intermediárias e terminais.
     * - intermediárias: retornam um stream e podem ser encadeadas
     * - terminais: retornam um objeto, ou um valor, e não podem ser encadeadas
     */
    public static void main(String[] args) {
        // TODO git config --global user.name "Gabriel Dias"
        System.out.println("--\tImprimindo todos os itens da lista de String\t--");
        List<String> numerosListString = Arrays.asList("8", "5", "7", "3", "2", "1", "6", "9");
        numerosListString.forEach(System.out::println);
        System.out.println("=============================================================================");

        System.out.println("--\tColocando os 5 primeiros números em um Set\t--");
        Set<String> stringSet = numerosListString.stream().limit(5).collect(Collectors.toSet());
        System.out.println(stringSet);
        System.out.println("=============================================================================");
        /*
         * Set<String> collectSet =
         * numerosListString.stream().limit(5).collect(Collectors.toSet());
         * System.out.println(collectSet);
         * primeiro é estabelecido o limite dos elementos que serão usados com o método
         * limit, depois é usado o método
         * collect e, com a classe Collectors, o método toSet e o forEach com método de
         * referência para a saída do Set
         */

        System.out.println("--\tTransformando a lista de String em uma lista de inteiros\t--");
        List<Integer> integerList = numerosListString.stream()
                .map(Integer::parseInt) // o map() basicamente trabalha com todos os elementos de forma geral
                .toList(); // to list converte a Stream criada pelo map() para uma List
        System.out.println(integerList);
        System.out.println("=============================================================================");

        System.out.println("--\tColocando os números pares e maiores que 2 em uma lista\t--");
        List<Integer> numerosInteirosParesM2 = numerosListString.stream().map(Integer::parseInt).filter(i -> {
            return i % 2 == 0 && i > 2;
        }).collect(Collectors.toList());
        System.out.println(numerosInteirosParesM2);
        System.out.println("=============================================================================");

        System.out.println("--\tMostrando a média dos números\t--");
        numerosListString.stream()
                .mapToInt(Integer::parseInt)
                // mapToInt() serve para trabalhar com cada um dos valores presentes na lista e fazer alterações
                .average()
                // retorna um OptionalDouble contendo a média dos elementos da Stream
                .ifPresent(System.out::println); // se for presente, o ifPresent() retorna a média
        System.out.println("=============================================================================");


        // TODO System.out.println("--\tRemovendo os valores ímpares\t--");
    }
}
