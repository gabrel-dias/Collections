package cursoantigo.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComClasseAnonima {
    public static void main(String[] args) {
        List<Gato> gatoes = new ArrayList<>(){{
            add(new Gato("felipe", "branco", 14));
            add(new Gato("tomas", "preto", 12));
            add(new Gato("gustava", "marrom", 13));
        }};
        System.out.println(gatoes);
        gatoes.sort(new Comparator<>() { // o método sort precisa de uma interface comparadora
            // usando classe anônima, ou seja, não há uma classe especificada que
            // implementa o Comparator, é instanciado apenas a interface
            @Override
            public int compare(Gato o1, Gato o2) {
                // com a classe anônima, é preciso apenas fazer a lógica do retorno
                // com base no atributo desejado
                return Integer.compare(o1.getIdade(), o2.getIdade());
            }
        });
        System.out.println(gatoes);
    }
}