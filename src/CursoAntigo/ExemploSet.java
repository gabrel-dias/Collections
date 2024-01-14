package CursoAntigo;

// Os Sets (conjuntos) são utilizadas para criar uma lista de elementos que não irão receber alterações de inclusão ou exclusão
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class ExemploSet {
    public static void main(String[] args) {
        // criando a Set do tipo Double e atribuindo um array contendo as notas como
        // lista
        Set<Double> notasHashSet = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 3.6));
        // importante frisar que não é permitido adicionar elementos IGUAIS em um
        // conjunto (o compilador não acusa erro, mas ao utilizar os elementos, o
        // repetido não será utilizado)

        System.out.println("Exibindo elementos da lista de forma aleatória (HashSet)...");
        System.out.println(notasHashSet);
        System.out.println("Menor nota do conjunto: " + Collections.min(notasHashSet) + "\nMaior nota do conjunto: "
                + Collections.max(notasHashSet));
        // para que a soma seja possível, um iterator deve ser criado e a seguinte
        // lógica deve ser seguida: enquanto houver (hasNext) um próximo elemento no
        // conjunto, uma variável deve receber o valor desse elemento (next)
        Iterator<Double> iterator = notasHashSet.iterator();
        double soma = 0d;
        while (iterator.hasNext()) {
            double next = iterator.next();
            soma += next;
        }
        System.out.printf("Soma dos elementos do conjunto: %.2f\n", soma);
        // o método size() retorna a quantidade de elementos presentes no conjunto
        System.out.printf("Média dos elementos no conjunto: %.2f\n", soma / notasHashSet.size());
        System.out.println("Removendo a nota 3.6...");
        notasHashSet.remove(3.6);
        System.out.println(notasHashSet);
        System.out.println("Removendo notas menores que 7 e mostrando a lista...");

        Iterator<Double> iterator2 = notasHashSet.iterator();
        while (iterator2.hasNext()) {
            double next = iterator2.next();
            if (next < 7) { // se a condição for verdadeira, o elemento que for abaixo de 7 será removido
                iterator2.remove();
                // apesar de que seja criado um outro iterator() no conjunto, o que será
                // excluído é o dado do conjunto e não do iterator, pois o mesmo não é um Set
            }
        }
        System.out.println(notasHashSet);

        System.out.println("Exibir os elementos do conjunto em sua ordem de inserção (LinkedHashSet)... ");
        Set<Double> notasLinkedHash = new LinkedHashSet<>(); // não é possível manter uma ordem utilizando o HashSet,
                                                             // pois este gera uma ordem aleatória.
                                                             // é necessário utilizar o LinkedHashSet para que a lista
                                                             // fique organizada de acordo com a ordem de inserção
        notasLinkedHash.add(9.3);
        notasLinkedHash.add(7d);
        notasLinkedHash.add(5d);
        notasLinkedHash.add(3.6);
        notasLinkedHash.add(7d); // ignorado por ser igual
        notasLinkedHash.add(8.5);
        System.out.println(notasLinkedHash);

        Set<Double> notasTreeSet = new TreeSet<>(notasHashSet); // a implementação TreeSet
                                                                // organiza os elementos de
                                                                // maneira crescente.
                                                                // só é possível passar outro conjunto no argumento se
                                                                // este mesmo conjunto for do tipo que se está criando

        System.out.println("Exibindo os elementos com a ordem crescente (TreeSet)...");
        System.out.println(notasTreeSet);
        System.out.println("Apagando toda a lista...");
        notasTreeSet.clear();
        System.out.println(notasTreeSet);
        System.out.println("O conjunto está vazio?\n");
        if (notasTreeSet.isEmpty() == true)
            System.out.println("Sim");
        else
            System.out.println("Não");
    }

}