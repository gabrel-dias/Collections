package cursoantigo.stream;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class Contatos {

    private String nome;
    private int numero;

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public Contatos(String nome, int numero) {
        this.nome = nome;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Contato [nome=" + nome + ", numero=" + numero + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + numero;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contatos other = (Contatos) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (numero != other.numero)
            return false;
        return true;
    }

}

class ComparatorNumero implements Comparator<Map.Entry<Integer, Contatos>> {

    @Override
    public int compare(Entry<Integer, Contatos> o1, Entry<Integer, Contatos> o2) {
        return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
    }

}