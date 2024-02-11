package cursoantigo.stream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Agenda {
    public static void main(String[] args) {
        System.out.println("\t--Ordem aleatória--\t");
        Map<Integer, Contato> agenda = new HashMap<>() {
            {
                put(1, new Contato("Simba", 2222));
                put(4, new Contato("Cami", 5555));
                put(3, new Contato("Jon", 1111));
            }
        };
        System.out.println(agenda);
        for (Map.Entry<Integer, Contato> entry : agenda.entrySet()) { // entrySet sendo utilizado para trabalhar com os
            // elementos do dicionário de forma separada
            System.out.println(entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        System.out.println("\t--Ordem de inserção--\t");
        Map<Integer, Contato> agenda2 = new LinkedHashMap<>() {
            {
                put(3, new Contato("Jon", 1111));
                put(4, new Contato("Cami", 5555));
                put(1, new Contato("Simba", 2222));
                put(2, new Contato("Gabri", 6666));
            }
        };
        System.out.println(agenda2);
        for (Map.Entry<Integer, Contato> entry : agenda2.entrySet()) {
            System.out.println(entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }

        System.out.println("\t--Ordem de chave--\t");
        Map<Integer, Contato> agenda3 = new TreeMap<>(agenda2);
        System.out.println(agenda3);
        for (Map.Entry<Integer, Contato> entry : agenda3.entrySet()) {
            System.out.println(entry.getValue().getNome() + " - " + entry.getValue().getNumero());
        }
    }
}