import java.time.LocalDate;
import java.util.ArrayList;

public class BibliotecaEx03 {
    private ArrayList<AlunosEx03> listaAlunos;
	private ArrayList<ProfessoresEx03> listaProfessores;
    private ArrayList<LivrosEx03> livros = new ArrayList<>();
    private ArrayList<EmprestimoEx03> emprestimos = new ArrayList<>();
	
	public BibliotecaEx03() {
	    this.listaAlunos = new ArrayList<>();
		this.listaProfessores = new ArrayList<>();
        this.livros = new ArrayList<>();
	}

	public ArrayList<AlunosEx03> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ArrayList<AlunosEx03> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

	public ArrayList<ProfessoresEx03> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(ArrayList<ProfessoresEx03> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }

    public ArrayList<LivrosEx03> getListaLivros() {
        return livros;
    }

    public void setListaLivros(ArrayList<LivrosEx03> listaLivros) {
        this.livros = listaLivros;
    }

    public ArrayList<EmprestimoEx03> getEmprestimos() {
        return emprestimos;
    }  

    /* Funções referentes à cadastro, remoção e listagem de informações dos livros */
    public String cadastrarLivro(LivrosEx03 livros) {
        if (livros != null) {
            this.livros.add(livros);
            return "Livro cadastrado com sucesso!"; 
        } else{
            return "Houve algum erro ao realizar o cadastro, por favor tente novamente.";
        }
    }

    public String obterInformacoesLivros() {
        if (livros.isEmpty()) {
            return "Nenhum livro cadastrado";
        }
        
        String resultado = "Livros cadastrados:\n";
        for (LivrosEx03 livro : livros) {
            resultado += livro.exibirInfo() + "\n";
        }
        return resultado;
    }

    public LivrosEx03 buscarLivro(String codigoUnico) {
        for(LivrosEx03 livro : livros) {
            if(livro.getCodigoUnico().equals(codigoUnico)) {
                return livro;
            }
        }
        return null;
    }

    public boolean removerLivro(String codigoUnico) {
        LivrosEx03 livroParaRemover = buscarLivro(codigoUnico);
        if (livroParaRemover != null) {
            livros.remove(livroParaRemover);
            return true;
        }
        return false;
    }

    /* Funções referentes à cadastro, remoção e listagem de informações de usuários */
    public boolean cadastro(AlunosEx03 aluno) {
        if(aluno != null) {
            listaAlunos.add(aluno);
            return true;
        } else {
            return false;
        }
    }

    public boolean cadastro(ProfessoresEx03 professor) {
        if(professor != null) {
            listaProfessores.add(professor);
            return true;
        } else {
            return false;
        }
    }

    /* Funções referentes ao empréstimo, devolução e listagem dos livros */
    public String realizarEmprestimo(String codigoLivro, String codigoUsuario) {
        LivrosEx03 livro = buscarLivro(codigoLivro);
    
        if (livro == null) {
            return "Livro não encontrado.";
        }
    
        boolean usuarioValido = false;
        boolean isProfessor = false;
    
        for (AlunosEx03 aluno : listaAlunos) {
            if (aluno.getCodigo().equals(codigoUsuario)) {
                usuarioValido = true;
                break;
            }
        }
    
        if (!usuarioValido) {
            for (ProfessoresEx03 professor : listaProfessores) {
                if (professor.getCodigo().equals(codigoUsuario)) {
                    usuarioValido = true;
                    isProfessor = true;
                    break;
                }
            }
        }
    
        if (!usuarioValido) {
            return "Usuário não encontrado ou não autorizado para empréstimo.";
        }
    
        for (EmprestimoEx03 emp : emprestimos) {
            if (emp.getCodigoUsuario().equals(codigoUsuario) && !emp.isDevolvido()) {
                int diasEmprestado = java.time.Period.between(emp.getDataEmprestimo(), java.time.LocalDate.now()).getDays();
                int limiteDias = isProfessor ? 15 : 7;
                if (diasEmprestado > limiteDias) {
                    return "Usuário está com devoluções atrasadas e não pode realizar novos empréstimos.";
                }
            }
        }
    
        int livrosAtivos = 0;
        for (EmprestimoEx03 emp : emprestimos) {
            if (emp.getCodigoUsuario().equals(codigoUsuario) && !emp.isDevolvido()) {
                livrosAtivos++;
            }
        }
    
        if (livrosAtivos >= 3) {
            return "Usuário já possui 3 livros emprestados.";
        }
    
        if (livro.isFisico()) {
            for (EmprestimoEx03 emp : emprestimos) {
                if (emp.getLivro().equals(livro) && !emp.isDevolvido()) {
                    return "Livro físico já está emprestado. Aguardando devolução.";
                }
            }
        }
    
        EmprestimoEx03 novoEmprestimo = new EmprestimoEx03(livro, codigoUsuario);
        emprestimos.add(novoEmprestimo);
        return null;
    }    

    public boolean registrarDevolucao(String codigoLivro, String codigoUsuario) {
        for (EmprestimoEx03 emp : emprestimos) {
            if (
                emp.getLivro().getCodigoUnico().equals(codigoLivro) &&
                emp.getCodigoUsuario().equals(codigoUsuario) &&
                !emp.isDevolvido()
            ) {
                emp.setDevolvido(true);
                emp.setDataDevolucao(LocalDate.now());
                return true;
            }
        }
        return false;
    }
    
}
