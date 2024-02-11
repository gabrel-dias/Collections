package cursoantigo.stream;

import java.util.HashMap;
import java.util.Map;

public class Agenda {
    public static void main(String[] args) {
        Map<Integer, Contato> agendMap = new HashMap<>(){{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};
    }
}

class Contato {
    private String nome;
    private int numero;
    public String getNome() {
        return nome;
    }
    public int getNumero() {
        return numero;
    }
    public Contato(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }
    @Override
    public String toString() {
        return "Contato [nome=" + nome + ", numero=" + numero + "]";
    }
    
}