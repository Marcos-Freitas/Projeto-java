package util;

import livro.LivroBiblioteca;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import acervo.Acervo;


public class CSVUtils {
    public static void gerarCsvLivros(Path arquivo) throws IOException {
        List<LivroBiblioteca> livro = leCsv(arquivo);//não seria func ao inves de livro

        gerarCsvNovo("Livro_filtrado.csv", livro);//passando lista de livros

        livro.forEach((f) -> {
            //editar aqui pra ver o que chama no CSV
            System.out.println("Genero: " + f.getGenero() + "Autor: " + f.getAutor());
        });

    }

    //LEITURA

    //em string poderia passar o nome livros e depois em paths.get poderia passar o mesmo nome
    private static void gerarCsvNovo(String string, List<LivroBiblioteca> livro) throws IOException {
        String cabecalho = "Titulo, Autor, Genero\n";

        Path arquivoFinal = Paths.get("Livros.csv");

        try {
            Files.writeString(arquivoFinal, cabecalho, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

            //acho que nao precisa desse stringbuilder, pois ele serve para o filtro que comentei abaixo
            StringBuilder builder = new StringBuilder();


            
            
                //livro.stream().filter((f) -> f.getTitulo()!=0).forEach((f)-> {};
                livro.stream().forEach((f) -> {
                builder.append(f.getTitulo() + ",");
                builder.append(f.getAutor() + ",");
                builder.append(f.getGenero() + "\n");
                });
            
            

            //por isso acho tambem que nao precisamos desse Files abaixo, que vai impactar tmb no codigo comentado acima
            Files.writeString(arquivoFinal, builder.toString(), StandardOpenOption.APPEND);

        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        }

        Files.writeString(arquivoFinal, cabecalho);
    }

    private static List<LivroBiblioteca> leCsv (Path arquivo){
        List<LivroBiblioteca> livros = new ArrayList<>(); //criar lista de livros
        try {
            List<String> linhas = Files.readAllLines(arquivo);//Ler linha por linha do csv e colocar em uma lista
            linhas.remove(0);//tirar cabeçalho
            //para cada linha criar um livro
            linhas.forEach((linha) -> {
                String[] linhaSplit = linha.split(",");
                LivroBiblioteca book;
                System.out.println(linha);
                //Parseinte não vamos usar, pois só estamos usando string... 
                //o parseint converte string em numero
                 book = new LivroBiblioteca(linhaSplit[0],
                        linhaSplit[1],
                        linhaSplit[2]);
                Acervo.adicionar(book);
            });
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return livros; //devolver os livros
    }

}