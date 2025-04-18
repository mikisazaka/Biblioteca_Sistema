public class LivroFisicoEx03 extends LivrosEx03 {
    private int numeroDePaginas;
    private int numeroEstante;

    public LivroFisicoEx03(String codigoUnico, String titulo, String autor, int numeroDePaginas, int numeroEstante) {
        super(codigoUnico, titulo, autor);
        this.numeroDePaginas = numeroDePaginas;
        this.numeroEstante = numeroEstante;
    }

    @Override
    public String exibirInfo() {
        return "[LIVRO FÍSICO]" + super.exibirInfo() + 
               String.format("Número de páginas: %d\nNúmero da Estante: %d\n", 
                            numeroDePaginas, numeroEstante);
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public int getNumeroEstante() {
        return numeroEstante;
    }

    public void setNumeroEstante(int numeroEstante) {
        this.numeroEstante = numeroEstante;
    }
}
