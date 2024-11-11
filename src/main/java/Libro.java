/**
 *
 * @author josuedominguezlabrada
 */
//clase libro
public class Libro {
    private String titulo;
    private String autor;

    //constructor
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
    
    //Getter
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    //toString
    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor;
    }
}
