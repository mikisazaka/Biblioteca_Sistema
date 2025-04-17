public class Ebook extends Livros {
    private int numeroDePaginas;
    private String linkDownload;

    public Ebook(String codigoUnico, String titulo, String autor, int numeroPaginas, String linkDownload) {
        super(codigoUnico, titulo, autor);
        this.numeroDePaginas = numeroPaginas;
        this.linkDownload = linkDownload;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getLinkDownload() {
        return linkDownload;
    }

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }
}