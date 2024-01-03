package main.java.MeusExercícios.list.pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    // atributo
    private List<Livro> livrosList;

    // construtor da List com um ArrayList instanciado para que seja uma lista vazia
    public CatalogoLivros() {
        this.livrosList = new ArrayList<>();
    }

    // métodos
    // para adicionar, é chamado o construtor com o ArrayList e método "add()", onde
    // é feita a instanciação do objeto "Livro" que está na sua classe e possui os
    // atributos em seus parâmetros
    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livrosList.add(new Livro(titulo, autor, anoPublicacao));
    }

    // cria-se um método que retornará uma List<Livro>, e é feita uma verificação se
    // a lista mãe está vazia, se não estiver, a negação torna o booleano true e
    // executa o bloco
    // é feito um forEach que roda todos os elementos da lista mãe e se existir um
    // elemento com o mesmo autor, que é passado no parâmetro, esse elemento é
    // adicionado na lista e no fim, é retornado a lista contendo todos os livros
    // com o mesmo autor, que foram armazenados na lista
    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if (!livrosList.isEmpty()) {
            for (Livro l : livrosList) {
                if (l.getAutor().equalsIgnoreCase(autor)) {
                    livrosPorAutor.add(l);
                }
            }
        }
        return livrosPorAutor;
    }

    // no segundo if é verificado se o ano de publicação está dentro do perío"do
    // especificado (inicial e final), se houverem elementos com essa condição, os
    // mesmos serão adicionados na lista de anos
    public List<Livro> pesquisarPorAno(int anoInicial, int anoFinal) {
        List<Livro> livrosPorAno = new ArrayList<>();
        if (!livrosList.isEmpty()) {
            for (Livro l : livrosList) {
                if (l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                    livrosPorAno.add(l);
                }
            }
        }
        return livrosPorAno;
    }

    // o null é atribuído pois não há nenhum objeto com o título em questão
    //
    public Livro pesquisarPorTitulo(String titulo) {
        Livro livroTitulo = null;
        if (!livrosList.isEmpty()) {
            for (Livro l : livrosList) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    livroTitulo = l;
                    break;
                }
            }
        }
        return livroTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros livros = new CatalogoLivros();
        livros.adicionarLivro("cthulhu", "lovecraft", 1928);
        livros.adicionarLivro("shub-niggurath", "lovecraft", 1928);
        livros.adicionarLivro("o corvo", "alan poe", 1845);
        System.out.println("POR AUTOR " + livros.pesquisarPorAutor("lovecraft"));
        System.out.println("POR ANO " + livros.pesquisarPorAno(1920, 1930));
        System.out.println("POR TÍTULO " + livros.pesquisarPorTitulo("o CORVO"));
    }
}