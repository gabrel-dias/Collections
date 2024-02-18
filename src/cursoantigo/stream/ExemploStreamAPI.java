package cursoantigo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExemploStreamAPI {
        /*
        as streams possuem dois tipos de operações: intermediárias e terminais.
        - intermediárias: retornam um stream e podem ser encadeadas
        - terminais: retornam um objeto, ou um valor, e não podem ser encadeadas
         */
    public static void main(String[] args) {
        System.out.println("--\tImprimindo todos os itens da lista de String\t--");
        List<String> numeros = Arrays.asList("8", "5", "7", "3", "2", "1", "6");
        numeros.forEach(System.out::println);

        System.out.println("--\tColocando os 5 primeiros números em um Set\t--");
        numeros.stream().limit(5).collect(Collectors.toSet()).forEach(System.out::println);
        /*
        Set<String> collectSet = numeros.stream().limit(5).collect(Collectors.toSet());
        System.out.println(collectSet);
        primeiro é estabelecido o limite dos elementos que serão usados com o método limit, depois é usado o método
        collect e, com a classe Collectors, o método toSet e o forEach com método de referência para a saída do Set
         */


        System.out.println("--\tTransformando a lista de String em uma lista de inteiros\t--");

    }
}
