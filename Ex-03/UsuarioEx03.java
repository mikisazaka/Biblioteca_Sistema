public class UsuarioEx03 {
    private String codigoUnico;
    private String nomeCompleto;

    public UsuarioEx03(String codigoUnico, String nomeCompleto) {
        this.codigoUnico = codigoUnico;
        this.nomeCompleto = nomeCompleto;
    }

    public String getCodigo() {
        return codigoUnico;
    }

    public void setCodigo(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getNome() {
        return nomeCompleto;
    }

    public void setNome(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }
}
