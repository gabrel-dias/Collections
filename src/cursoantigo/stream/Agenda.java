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
        System.out.println(agenda);
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
        Map<Integer, Contatos> agenda3 = new TreeMap<>(agenda2);
        System.out.println(agenda3);
        for (Map.Entry<Integer, Contatos> entry : agenda3.entrySet()) {
            System.out.println(entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        System.out.println("--\tOrdem de numero\t--");
        Set<Map.Entry<Integer, Contatos>> set = new TreeSet<>(new Comparator<Entry<Integer, Contatos>>() {
            @Override
            public int compare(Entry<Integer, Contatos> o1, Entry<Integer, Contatos> o2) {
                return 0;
            }
        });
        set.addAll(agenda3.entrySet());
        for (Entry<Integer, Contatos> entry : set) {
            System.out.println(entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        System.out.println("--\tOrdem de contato\t--");
        Set<Map.Entry<Integer, Contatos>> set2 = new TreeSet<>(new Comparator<Entry<Integer, Contatos>>() {
            @Override
            public int compare(Entry<Integer, Contatos> o1, Entry<Integer, Contatos> o2) {
                return 0;
            }
        });
        set2.addAll(agenda3.entrySet());
        for (Entry<Integer, Contatos> entry : set2) {
            System.out.println(entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

    }
}