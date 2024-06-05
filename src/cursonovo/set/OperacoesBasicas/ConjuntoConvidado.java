package cursonovo.set.OperacoesBasicas;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoConvidado {
    // atributo
    private Set<Convidado> convidadoSet;

    // construtor
    public ConjuntoConvidado() {
        this.convidadoSet = new HashSet<>();
    }
    // métodos
    public void adicionarConvidados(String nome, int codigoConvite){
        convidadoSet.add(new Convidado(nome, codigoConvite));
        // o método add requer um elemento como atributo; por isso, é passado o construtor da classe convidado que precisa do nome e codigo
    }

    public void removerConvidadoPorCodigo(int codigoConvite){
        // o código do convite é a chave estrangeira do convidado
        Convidado convidadoARemover = null;
        for(Convidado c : convidadoSet){
            if (c.getCodigoConvite() == codigoConvite){
                convidadoARemover = c;
                break;
            }
        }
    convidadoSet.remove(convidadoARemover);
    }

    public int contarConvidados(){
        return convidadoSet.size();
    }

    public void exibirConvidados(){
        System.out.println(convidadoSet);
    }
}
