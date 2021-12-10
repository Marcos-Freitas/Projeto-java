package livro;

public class LivroBiblioteca {
    // Atributos
    private String titulo;
    private String autor;
    private String genero;

    //Construtor
    public LivroBiblioteca() { } //Default

    public LivroBiblioteca(String titulo, String autor, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;

    }
    //Métodos

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String getAutor() {

        return autor;
    }

    public void setAutor(String autor) {

        this.autor = autor;
    }

    public String getGenero() {

        return genero;
    }

    public void setGenero(String genero) {

        this.genero = genero;
    }

    //Métodos da classe
    public String imprimir(){
        return"Título: " + titulo + "\nAutor: " +autor + "\nGenero: " + genero;
    }

  
}
