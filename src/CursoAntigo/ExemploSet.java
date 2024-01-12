package CursoAntigo;

// As Sets são utilizadas para criar uma lista de elementos que não irão receber alterações
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ExemploSet {
    public static void main(String[] args) {
        // criando a Set do tipo Double e atribuindo um array contendo as notas como
        // lista
        Set<Double> notasSet = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 3.6));
        // importante frisar que não é permitido adicionar elementos IGUAIS em um
        // conjunto
        System.out.println(notasSet);
        System.out.println("Menor nota do conjunto: " + Collections.min(notasSet) + "\nMaior nota do conjunto: "
                + Collections.max(notasSet));
        // para que a soma seja possível, um iterator deve ser criado e a seguinte
        // lógica deve ser seguida: enquanto houver (hasNext) um próximo elemento no
        // conjunto, uma variável deve receber o valor desse elemento (next)
        Iterator<Double> iterator = notasSet.iterator();
        double soma = 0d;
        while (iterator.hasNext()) {
            double next = iterator.next();
            soma += next;
        }
        System.out.printf("Exibir a soma dos elementos do conjunto : %.2f\n", soma);
        // o método size() retorna a quantidade de elementos presentes no conjunto
        System.out.printf("A média dos elementos no conjunto é: %.2f\n", soma / notasSet.size());
        System.out.println("Removendo a nota 3.6...");
        notasSet.remove(3.6);
        System.out.println(notasSet);
        System.out.println("Removendo notas menores que 7 e mostrando a lista...");

        Iterator<Double> iterator2 = notasSet.iterator();
        while (iterator2.hasNext()) {
            double next = iterator2.next();
            if (next < 7) { // se a condição for verdadeira, o elemento que for abaixo de 7 será removido
                iterator2.remove();
            }
        }
        // apesar de que seja criado um outro iterator() no conjunto, o iterador mantém
        // um controle sobre o conjunto
        System.out.println(notasSet);

        System.out.println("Exibir os elementos do conjunto em sua ordem de inserção... ");
        Set<Double> notasLinkedHash = new LinkedHashSet<>(); // não é possível manter uma ordem utilizando o HashSet,
                                                             // para isso, é necessário utilizar o LinkedHashSet
        notasLinkedHash.add(9.3);
        notasLinkedHash.add(7d);
        notasLinkedHash.add(5d);
        notasLinkedHash.add(3.6);
        notasLinkedHash.add(7d); //ignorado por ser igual
        notasLinkedHash.add(8.5);
        System.out.println(notasLinkedHash);
    } 

}