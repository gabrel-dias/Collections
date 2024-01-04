package MeusExercícios.set.pesquisa;

public class Contato {
    private String nome;
    private int numeroDeTelefone;

    public Contato(String nome, int numeroDeTelefone) {
        this.nome = nome;
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    @Override
    public String toString() {
        return "Contato [nome=" + nome + ", numeroDeTelefone=" + numeroDeTelefone + "]";
    }

}
