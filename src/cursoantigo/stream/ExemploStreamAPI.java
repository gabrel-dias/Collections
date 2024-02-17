package cursoantigo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExemploStreamAPI {
        /* as streams possuem dois tipos de operações: intermediárias e terminais.
        - intermediárias: retornam um stream e podem ser encadeadas
        - terminais: retornam um objeto, ou um valor, e não podem ser encadeadas
         */
    public static void main(String[] args) {
        System.out.println("--\tImprimindo todos os itens da lista de String\t--");
        List<String> inteiros = Arrays.asList("8", "5", "7", "3", "8", "1", "6");
        inteiros.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
    }
}
