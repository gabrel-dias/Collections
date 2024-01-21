package exercícios.list.basicas;

public class Tarefa {
    // atributo
    private String descricao;

    // getter
    public String getDescricao() {
        return descricao;
    }

    // construtor
    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
        
}