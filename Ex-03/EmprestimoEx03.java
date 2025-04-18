import java.time.LocalDate;

public class EmprestimoEx03 {
    private LivrosEx03 livro;
    private String codigoUsuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private boolean devolvido;

    public EmprestimoEx03(LivrosEx03 livro, String codigoUsuario) {
        this.livro = livro;
        this.codigoUsuario = codigoUsuario;
        this.dataEmprestimo = LocalDate.now();
        this.devolvido = false;
    }

    public LivrosEx03 getLivro() {
        return livro;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }    

    public boolean isDevolvido() {
        return devolvido;
    } 

    public String exibirInfo() {
        return "Livro: " + livro.getTitulo() + " | Usuário: " + codigoUsuario +
                " | Emprestado em: " + dataEmprestimo +
                (devolvido ? " | Devolvido em: " + dataDevolucao : " | [EMPRÉSTIMO ATIVO]");
    }
}
