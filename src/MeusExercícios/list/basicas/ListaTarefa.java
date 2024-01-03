package main.java.MeusExercícios.list.basicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    
    // atributo
    private List<Tarefa> tarefaLista;

    // construtor
    public ListaTarefa() {
        this.tarefaLista = new ArrayList<>();
    }

    // métodos
    public void adicionarTarefa(String descricao) {
        tarefaLista.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for (Tarefa t : tarefaLista) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                tarefasParaRemover.add(t);
            }
            
        }
        tarefaLista.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas() {
        return tarefaLista.size();

    }

    public void obterDescricoesTarefas() {
        System.out.println(tarefaLista);
    }
    

}