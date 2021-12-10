//tem que ter na classe principal um path arquivo = paths.get("livros.csv")???
package Utils;

import acervo.Acervo;
import livro.LivroBiblioteca;
import util.CSVUtils;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Path arquivo= Paths.get("Livros.csv");
        try {
            CSVUtils.gerarCsvLivros(arquivo);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Scanner entrada = new Scanner(System.in);
        Scanner entradaString = new Scanner(System.in);

        int menu;

        //Referencias para classe LivroBiblioteca
        LivroBiblioteca objLivro;
        String titulo, autor, genero;

        do {
            exibirMenu();
            menu = entrada.nextInt();

            switch(menu){
                case 1:
                    System.out.println("===> Cadastro do Livro");
                    System.out.println("Digite o titulo: ");
                    titulo = entradaString.nextLine();
                    System.out.println("Digite o autor: ");
                    autor = entradaString.nextLine();
                    System.out.println("Digite o genero: ");
                    genero = entradaString.nextLine();

                    objLivro = new LivroBiblioteca(titulo,autor,genero);

                    //Guardar no ArrayList
                    Acervo.adicionar(objLivro);
                    break;
                case 2:
                    System.out.println("===> Lista dos Livros");
                    System.out.println(Acervo.listar());
                    break;
                case 3:
                    System.out.println("Remover por título do livro");
                    System.out.println("Digite o titulo do livro");
                    titulo= entradaString.nextLine();

                    if ( !(Acervo.getListaLivros().isEmpty())){ // acervo não está vazio
                        if( Acervo.remover(titulo)){
                            System.out.println("Livro removido com sucesso!");
                        }else{
                            System.out.println("Título não encontrado");
                        }
                    }else{
                        System.out.println("O acervo está vazio!");
                    }
                    break;
                case 4:
                    System.out.println("===> Pesquisar por autor");
                    System.out.println("Digite o autor");
                    autor = entradaString.nextLine();
                    System.out.println("Há " + Acervo.pesquisarAutor(autor) + "livro (s) do autor " + autor);
                    break;
                case 5:
                    System.out.println("===> Pesquisar por genero");
                    System.out.println("Digite o genero");
                    genero = entradaString.nextLine();
                    System.out.println("Há " + Acervo.pesquisarGenero(genero) + "livro (s) do genero" + genero);
                    break;
                case 6:
                    System.out.println("Encerrando");
                    break;
                default:
                    System.out.println("Opção de menu inválida!");
            }
        } while (menu != 6);

        // List<LivroBiblioteca> listaLivro = new ArrayList<LivroBiblioteca>();
    }
//Fim da main

    static void exibirMenu() {
        System.out.println("======= Livro Biblioteca =======");
        System.out.println("1 - ADICIONAR");
        System.out.println("2 - LISTAR");
        System.out.println("3 - EXCLUIR LIVRO");
        System.out.println("4 - PESQUISAR POR AUTOR");
        System.out.println("5 - PESQUISAR POR GENERO");
        System.out.println("6 - SAIR");
        System.out.println("====> Escolha uma opção: ");
    }
}
