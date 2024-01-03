package MeusExercícios.set.basicas;

public class Convidado implements Comparable<Convidado> {
    // atributos
    private String nome;
    private int codigoConvite;

    // construtores
    public Convidado(String nome, int codigoConvite) {
        this.nome = nome;
        this.codigoConvite = codigoConvite;
    }

    // getters
    public String getNome() {
        return nome;
    }

    public int getCodigoConvite() {
        return codigoConvite;
    }

    @Override
    public int compareTo(Convidado c) {
        return this.codigoConvite - c.getCodigoConvite();
    }

    @Override
    public String toString() {
        return "Convidado [nome=" + nome + ", codigoConvite=" + codigoConvite + "]";
    }

    
}
