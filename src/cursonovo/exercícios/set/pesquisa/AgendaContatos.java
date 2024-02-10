package cursonovo.exercícios.set.pesquisa;

import java.util.HashSet;
import java.util.Set;

public class AgendaContatos {
    private Set<Contato> agendaContatosSet;

    public AgendaContatos() {
        this.agendaContatosSet = new HashSet<>();
    }

    public void adicionarContato(String nome, int numero) {
        agendaContatosSet.add(new Contato(nome, numero));
    }

    public Set<Contato> exibirContatos() {
        return agendaContatosSet;
    }

    public Set<Contato> pesquisarPorNome(String nome) {
        Set<Contato> pesquisaNome = new HashSet<>();
        if (!agendaContatosSet.isEmpty()) {
            for (Contato c : agendaContatosSet) {
                if (c.getNome().startsWith(nome)) {
                    pesquisaNome.add(c);
                }
            }

            System.out.println("Contato encontrado pela pesquisa: ");
        }
        return pesquisaNome;
    }

    public Contato atualizarNumero(String nome, int novoNumero) {
        Contato contatoAtualizado = null;
        if (!agendaContatosSet.isEmpty()) {
            for (Contato c : agendaContatosSet) {
                if (c.getNome().equalsIgnoreCase(nome)) {
                    c.setNumeroDeTelefone(novoNumero);
                    contatoAtualizado = c;
                    break;
                }
            }
        }
        System.out.println("Contato após atualização:");
        return contatoAtualizado;
    }

    public static void main(String[] args) {
        AgendaContatos contatos = new AgendaContatos();

        contatos.adicionarContato("Gabriel", 23);
        contatos.adicionarContato("Bruna", 23);
        System.out.println("Exibindo contatos:\n" + contatos.exibirContatos());
        System.out.println(contatos.pesquisarPorNome("Bruna"));
        System.out.println(contatos.atualizarNumero("gabriel", 24));
    }
}
