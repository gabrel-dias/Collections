package MeusExercícios.set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    Set<Contato> agendaContatosSet;

    public AgendaContatos() {
        this.agendaContatosSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero){
        agendaContatosSet.add(new Contato(nome, numero));
    }

    public Set<Contato> exibirContatos(){
        return agendaContatosSet;
    }

    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> pesquisaNome;
        if (!agendaContatosSet.isEmpty()) {
            for (Contato c : agendaContatosSet) {
                if (c.) {
                    
                }
            }
        }
    }
}
