package cursonovo.exercicios.set.basicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasSet = new HashSet<>();
    }

    @Override
    public String toString() {
        return "ConjuntoPalavrasUnicas [palavrasSet=" + palavrasSet + "]";
    }

    public void adicionarPalavra(String palavra) {
        palavrasSet.add(palavra);
    }

    public void removerPalavra(String palavra) {
        if (palavrasSet.contains(palavra)) {
            palavrasSet.remove(palavra);
        }
        else
        System.out.println("A palavra digitada não foi encontrada no conjunto.");

    }

    public void verificarPalavra(String palavra) {
            if (palavrasSet.contains(palavra)) {
                System.out.println("A palavra solicitada está presente no conjunto.");
            } else
                System.out.println("A palavra solicitada não está presente no conjunto.");
    }

    public void exibirPalavrasUnicas() {
        System.out.println(palavrasSet);
    }

    public static void main(String[] args) {
        ConjuntoPalavrasUnicas palavras = new ConjuntoPalavrasUnicas();

        palavras.adicionarPalavra("batata");
        palavras.adicionarPalavra("bola");
        palavras.adicionarPalavra("parede");

        palavras.exibirPalavrasUnicas();

        palavras.removerPalavra("bola");
        System.out.println("Removendo palavra...");
        palavras.exibirPalavrasUnicas();

        palavras.verificarPalavra("paredão");

    }

}