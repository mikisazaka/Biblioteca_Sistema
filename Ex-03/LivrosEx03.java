public class LivrosEx03 {
    private String codigoUnico;
    private String titulo;
    private String autor;

    public LivrosEx03(String codigoUnico, String titulo, String autor) {
        this.codigoUnico = codigoUnico;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String exibirInfo() {
        return String.format("\nCódigo único: %s\nTítulo: %s\nAutor: %s\n", 
                            codigoUnico, titulo, autor);
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

    public boolean isFisico() {
        return true;
    }
}
