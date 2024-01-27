package cursoantigo.exercíciospropostos;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetExercicioProposto01 {
    /*
     * Crie um conjunto contendo as cores do arco-íris e:
     * 
     * Exiba todas as cores uma abaixo da outra
     * 
     * A quantidade de cores que o arco-íris tem
     * 
     * Exiba as cores em ordem alfabética
     * 
     * Exiba as cores na ordem inversa da que foi informada
     * 
     * Exiba todas as cores que começam com a letra ”v”
     * 
     * Remova todas as cores que não começam com a letra “a”
     * 
     * Limpe o conjunto
     * 
     * Confira se o conjunto está vazio
     */
    public static void main(String[] args) {
        Set<Cores> coresSet = new TreeSet<>() {
            {
                add(new Cores("vermelho"));
                add(new Cores("laranja"));
                add(new Cores("amarelo"));
                add(new Cores("verde"));
                add(new Cores("azul"));
                add(new Cores("anil"));
                add(new Cores("roxo"));

            }
        };
        // descobri que se deixar o System.out.println() abaixo da inserção dos
        // elementos, o compilador ignora essa linha
        System.out.println("\nExibindo cores uma abaixo da outra e em ordem alfabética: ");
        for (Cores cores : coresSet) {
            System.out.println(cores); // como os elementos comparados são iguais o retorno do método é zero, e são
                                       // organizados em ordem alfabética
        }

        System.out.println("\nQuantidade de cores do arco-íris: " + coresSet.size());

        System.out.println("\nConjunto de cores em ordem invertida: "); // utilização do ComparatorCoresInversas com
                                                                        // retorno -1
        Set<Cores> coresInversas = new TreeSet<>(new ComparatorCoresInversas());
        coresInversas.addAll(coresSet);
        for (Cores cores : coresInversas) {
            System.out.println(cores);
        }

        System.out.println("\nTodas as cores que começam com a letra \"V\":");
        Set<Cores> coresComV = new TreeSet<>(); // criação de um novo Set e adicionando todos os elementos do primeiro
                                                // Set
        coresComV.addAll(coresSet);

        Iterator<Cores> iteratorV = coresComV.iterator();
        while (iteratorV.hasNext()) { // enquanto houver um próximo elemento no Set, o iterator continuará adicionando
                                      // elementos na varíavel "coresV"

            Cores coresV = iteratorV.next(); // NÃO pode criar um atributo usando outro tipo além do tipo estabelecido
                                             // no
                                             // iterator
            if (coresV.getCor().startsWith("v")) // se o prefixo de algum elemento for "V", a saída mostrará esse
                                                 // elemento
                System.out.println(coresV);

        }

        System.out.println("\nRemovendo as cores que NÃO começam com \"A\" e mostrando os elementos restantes:");
        Set<Cores> coresSemV = new TreeSet<>();
        coresSemV.addAll(coresSet);

        Iterator<Cores> iteratorSemV = coresSemV.iterator();
        while (iteratorSemV.hasNext()) {
            Cores corSemV = iteratorSemV.next();
            if (!corSemV.getCor().startsWith("a")) // caso um elemento não tenha o prefixo "A", ele será removido do Set
                                                   // e serão mostrados os elementos restantes
                iteratorSemV.remove();
        }
        for (Cores cores : coresSemV) {
            System.out.println(cores);

        }
        System.out.println("\nLimpando o conjunto...");
        coresSet.removeAll(coresSet);

        if (coresSet.isEmpty() == true)
            System.out.println("\nO conjunto está vazio? Sim\n");
    }
}

class Cores implements Comparable<Cores> {

    private String cor;

    public Cores(String cor) {
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "cor = " + cor;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cor == null) ? 0 : cor.hashCode());
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
        Cores other = (Cores) obj;
        if (cor == null) {
            if (other.cor != null)
                return false;
        } else if (!cor.equals(other.cor))
            return false;
        return true;
    }

    @Override
    public int compareTo(Cores o) {
        return this.getCor().compareTo(o.getCor());
    }
}

class ComparatorCoresInversas implements Comparator<Cores> {

    @Override
    public int compare(Cores o1, Cores o2) {
        return -1;
    }

}
