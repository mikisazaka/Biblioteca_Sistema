public class UsuarioEx03 {
    private int codigoUnico;
    private String nomeCompleto;

    public UsuarioEx03(int codigoUnico, String nomeCompleto) {
        this.codigoUnico = codigoUnico;
        this.nomeCompleto = nomeCompleto;
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
