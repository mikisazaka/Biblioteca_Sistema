public class Livros {
    private String codigoUnico;
    private String titulo;
    private String autor;

    public Livros(String codigoUnico, String titulo, String autor) {
        this.codigoUnico = codigoUnico;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

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
}