package acervo;

import livro.LivroBiblioteca;

import java.util.ArrayList;

public class Acervo {
    private static ArrayList<LivroBiblioteca> listaLivros = new ArrayList<>();

    //Método Getter
    public static ArrayList<LivroBiblioteca> getListaLivros() {

        return listaLivros;
    }

    //Adicionar um objeto na lista
    public static void adicionar(LivroBiblioteca l) {
        listaLivros.add(l);
    }

    //Lista todos os objetos da lista
    public static String listar() {
        String saida = "";
        int i = 1;
        for (LivroBiblioteca l : listaLivros) {
            saida += "\n====== Livro Nº " + (i++) + "=====\n";
            saida += l.imprimir() + "\n";
        }
        return saida;
    }

    //Pesquisar por autor
    public static int pesquisarAutor(String autor) {
        int qtd = 0;

        for (LivroBiblioteca l : listaLivros) {
            if (l.getAutor().equalsIgnoreCase(autor)){
                qtd++;
            }
        }
        return qtd;
    }
    //Pesquisar por genero
    public static int pesquisarGenero(String genero) {
        int qtd = 0;

        for (LivroBiblioteca l : listaLivros) {
            if (l.getGenero().equalsIgnoreCase(genero)) {
                qtd++;
            }
        }
        return qtd;
    }

    //Pesquisar por titulo
    public static int pesquisarTitulo(String titulo) {
        int qtd = 0;
        for (LivroBiblioteca l : listaLivros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                qtd++;
            }
        }
        return qtd;
    }

    //Remove um livro pelo título
    static public boolean remover(String titulo){
        for(LivroBiblioteca l :listaLivros){
            if(l.getTitulo().equalsIgnoreCase(titulo)){
                listaLivros.remove(l);
                return true;
            }
        }
        return false;
    }
}




