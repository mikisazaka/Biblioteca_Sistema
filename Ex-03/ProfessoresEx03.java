public class ProfessoresEx03 extends UsuarioEx03 {
    private String areaAtuacao;
    private String departamento;
    private String email;

    public ProfessoresEx03(int codigoUnico, String nomeCompleto, String areaAtuacao, String departamento, String email) {
        super(codigoUnico, nomeCompleto);
        this.areaAtuacao = areaAtuacao;
        this.departamento = departamento;
        this.email = email;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
