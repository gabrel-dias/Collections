package cursonovo.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidado {
    private Set<Convidado> convidadoSet;

    public ConjuntoConvidado(Set<Convidado> convidadoSet) {
        this.convidadoSet = new HashSet<>();
    }

    public void adicionarConvidados(String nome, int codigoConvite){
        convidadoSet.add(new Convidado(nome, codigoConvite));
        // o método add requer um elemento como atributo; por isso, é passado o construtor da classe convidado que precisa do nome e codigo
    }
    public void removerConvidadoPorCodigo(String codigoConvite){
        // o código do convite é a chave estrangeira do convidado
    }
}
