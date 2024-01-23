package cursoAntigo.exercíciosPropostos;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetExercicioProposto02 {
    /*
     * Crie uma classe LinguagemFavorita que possua os atributos nome, anoDeCriacao
     * e ide. Em seguida, crie um conjunto com 3 linguagens e faça um programa que
     * ordene esse conjunto por:
     * Ordem de Inserção (linkedhashset)
     * Ordem Natural (nome) (treeset)
     * IDE
     * Ano de criação e nome
     * Nome, ano de criacao e IDE
     * Ao final, exiba as linguagens no console, um abaixo da outra.
     */

    public static void main(String[] args) {
        Set<LinguagemFavorita> favoritas = new LinkedHashSet<>() {
            {
                add(new LinguagemFavorita("java", 1995, "net beans"));
                add(new LinguagemFavorita("phyton", 1991, "pycharm"));
                add(new LinguagemFavorita("c", 1972, "dev-c++"));
            }
        };
    }
}

class LinguagemFavorita {
    private String nome;
    private int anoCriacao;
    private String ide;

    public LinguagemFavorita(String nome, int anoDeCriacao, String ide) {
        this.nome = nome;
        this.anoCriacao = anoDeCriacao;
        this.ide = ide;
    }

    public String getNome() {
        return nome;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public String toString() {
        return "nome = " + nome + ", ano de criação = " + anoCriacao + ", ide = " + ide;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        result = prime * result + anoCriacao;
        result = prime * result + ((ide == null) ? 0 : ide.hashCode());
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
        LinguagemFavorita other = (LinguagemFavorita) obj;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        if (anoCriacao != other.anoCriacao)
            return false;
        if (ide == null) {
            if (other.ide != null)
                return false;
        } else if (!ide.equals(other.ide))
            return false;
        return true;
    }

}
