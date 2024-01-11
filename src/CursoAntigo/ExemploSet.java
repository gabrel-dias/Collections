package CursoAntigo;

// As Sets são utilizadas para criar uma lista de elementos que não irão receber alterações
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
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
        System.out.printf("Exibir a soma dos elementos do conjunto : %.2f", soma);

    }

}