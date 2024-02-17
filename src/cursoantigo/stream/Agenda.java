package cursoantigo.stream;

import java.util.*;
import java.util.Map.Entry;

public class Agenda {
    public static void main(String[] args) {
        System.out.println("--\tOrdem aleatória\t--");
        Map<Integer, Contatos> agenda = new HashMap<>() {
            {
                put(1, new Contatos("Simba", 2222));
                put(4, new Contatos("Cami", 5555));
                put(3, new Contatos("Jon", 1111));
            }
        };

        for (Map.Entry<Integer, Contatos> entry : agenda.entrySet()) { // entrySet sendo utilizado para trabalhar com os
                                                                       // elementos do dicionário de forma separada
            System.out.println(entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        System.out.println("--\tOrdem de inserção\t--");
        Map<Integer, Contatos> agenda2 = new LinkedHashMap<>() {
            {
                put(3, new Contatos("Jon", 1111));
                put(4, new Contatos("Cami", 5555));
                put(1, new Contatos("Simba", 2222));
                put(2, new Contatos("Gabri", 6666));
            }
        };
        System.out.println(agenda2);
        for (Map.Entry<Integer, Contatos> entry : agenda2.entrySet()) {
            System.out.println(entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        System.out.println("--\tOrdem de chave\t--");
        Map<Integer, Contatos> agenda3 = new TreeMap<>(agenda2); // ordenação padrão do TreeMap é pela chave
        System.out.println(agenda3);
        for (Map.Entry<Integer, Contatos> entry : agenda3.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        System.out.println("--\tOrdem de numero\t--");
        /* Set<Map.Entry<Integer, Contatos>> set = new TreeSet<>(new Comparator<Entry<Integer, Contatos>>() {
            utilização de classe anônima na interface
            @Override
            public int compare(Entry<Integer, Contatos> o1, Entry<Integer, Contatos> o2) {
                return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
            }
        }); */

        /* Set<Map.Entry<Integer, Contatos>> set = new TreeSet<>(Comparator.comparing(
                new Function<Entry<Integer, Contatos>, Integer>() {
                    interessante notar que depois da vírgula dessa instanciação, é definido
                    qual o tipo do atributo que será usado na comparação, nesse caso "Integer"
            @Override
            public Integer apply(Entry<Integer, Contatos> integerContatosEntry) {
                return integerContatosEntry.getValue().getNumero();
            }
        })); */

        /* utilização do método estático do Comparator(comparing), que precisa ter uma Function.
         o tipo de retorno da Function deve ser alterado para o tipo que se deseja ser
         retornado e após isso, é só implementar o método apply() e fazer o @Override no return */

        Set<Map.Entry<Integer, Contatos>> set = new TreeSet<>( // utilização do lambda no método comparing
                // pelo que eu entendi, o lambda serve para "simplificar", fazendo suposições fodas
                // sobre as classses e interfaces
                Comparator.comparing(integerContatosEntry -> integerContatosEntry.getValue().getNumero()));
        set.addAll(agenda3.entrySet());
        for (Entry<Integer, Contatos> entry : set) {
            System.out.println(entry.getValue().getNumero() + " - " + entry.getValue().getNome());
        }

        System.out.println("--\tOrdem de contato\t--");
        Set<Map.Entry<Integer, Contatos>> set2 = new TreeSet<>(
                Comparator.comparing(integerContatosEntry -> integerContatosEntry.getValue().getNome()));
        set2.addAll(agenda3.entrySet());
        for (Entry<Integer, Contatos> entry : set2) {
            System.out.println(entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

    //TODO continuar aqui na próxima aula
    }
}