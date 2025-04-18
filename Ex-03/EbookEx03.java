public class EbookEx03 extends LivrosEx03 {
    private int numeroDePaginas;
    private String linkDownload;

    public EbookEx03(String codigoUnico, String titulo, String autor, int numeroPaginas, String linkDownload) {
        super(codigoUnico, titulo, autor);
        this.numeroDePaginas = numeroPaginas;
        this.linkDownload = linkDownload;
    }

    @Override
    public String exibirInfo() {
        return "[E-BOOK]" + super.exibirInfo() + 
               String.format("Número de páginas: %d\nLink do Download: %s\n", 
                            numeroDePaginas, linkDownload);
    }

    @Override
    public boolean isFisico() {
        return false;
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
