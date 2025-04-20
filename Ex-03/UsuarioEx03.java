public class UsuarioEx03 {
    private String codigoUnico;
    private String nomeCompleto;
    private String emprestimos;

    public UsuarioEx03(String codigoUnico, String nomeCompleto) {
        this.codigoUnico = codigoUnico;
        this.nomeCompleto = nomeCompleto;
    }

    public String exibirDados() {
        return String.format("\nCódigo único: %d\nNome completo: %s\n", codigoUnico, nomeCompleto);
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

    public String getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(String emprestimos) {
        this.emprestimos = emprestimos;
    }
}
