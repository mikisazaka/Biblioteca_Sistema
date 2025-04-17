public class Usuario {
    private int codigoUnico;
    private String nomeCompleto;

    public Usuario(int codigoUnico, String nomeCompleto) {
        this.codigoUnico = codigoUnico;
        this.nomeCompleto = nomeCompleto;
    }

    public String exibirDados() {
        return String.format("\nCódigo único: %d\nNome completo: %s\n", codigoUnico, nomeCompleto);
    }

    public int getCodigo() {
        return codigoUnico;
    }

    public void setCodigo(int codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getNome() {
        return nomeCompleto;
    }

    public void setNome(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
}