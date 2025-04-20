
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        } else {
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
        for (LivrosEx03 livro : livros) {
            if (livro.getCodigoUnico().equals(codigoUnico)) {
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
        if (aluno != null) {
            listaAlunos.add(aluno);
            return true;
        } else {
            return false;
        }
    }

    public boolean cadastro(ProfessoresEx03 professor) {
        if (professor != null) {
            listaProfessores.add(professor);
            return true;
        } else {
            return false;
        }
    }

    public boolean remocao(String codigo) {
        for (AlunosEx03 a : listaAlunos) {
            if (a.getCodigo().equals(codigo)) {
                listaAlunos.remove(a);
                return true;
            }
        }

        for (ProfessoresEx03 p : listaProfessores) {
            if (p.getCodigo().equals(codigo)) {
                listaProfessores.remove(p);
                return true;
            }
        }

        return false;
    }

    public AlunosEx03 buscarAlunoPorCodigo(String codigo) {
        for (AlunosEx03 a : listaAlunos) {
            if (a.getCodigo().equals(codigo)) {
                return a;
            }
        }

        return null;
    }

    public ProfessoresEx03 buscarProfessorPorCodigo(String codigo) {
        for (ProfessoresEx03 p : listaProfessores) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }

        return null;
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
                aluno.setEmprestimos(livro.getTitulo() + "\n");
                break;
            }
        }

        if (!usuarioValido) {
            for (ProfessoresEx03 professor : listaProfessores) {
                if (professor.getCodigo().equals(codigoUsuario)) {
                    usuarioValido = true;
                    isProfessor = true;
                    professor.setEmprestimos(livro.getTitulo() + "\n");
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
        boolean isProfessor = false;

        if (buscarProfessorPorCodigo(codigoUsuario) != null) {
            isProfessor = true;
        }

        int limiteDias = isProfessor ? 15 : 7;

        for (EmprestimoEx03 emp : emprestimos) {
            if (emp.getLivro().getCodigoUnico().equals(codigoLivro)
                    && emp.getCodigoUsuario().equals(codigoUsuario)
                    && !emp.isDevolvido()) {

                emp.setDevolvido(true);
                emp.setDataDevolucao(LocalDate.now());

                int diasEmprestado = java.time.Period.between(emp.getDataEmprestimo(), java.time.LocalDate.now()).getDays();
                if (diasEmprestado > limiteDias) {
                    emp.setDevolvidoDentroPrazo(false);
                } else {
                    emp.setDevolvidoDentroPrazo(true);
                }

                return true;
            }
        }
        return false;
    }

    public String listarEmprestimosAtivos() {
        String emprestimosAtivos = "";

        for (EmprestimoEx03 emp : emprestimos) {
            if (!emp.isDevolvido()) {

                boolean isProfessor = false;
                String nomeUsuario = "";

                if (buscarAlunoPorCodigo(emp.getCodigoUsuario()) != null) {
                    AlunosEx03 a = buscarAlunoPorCodigo(emp.getCodigoUsuario());
                    nomeUsuario = a.getNome();
                }

                if (buscarProfessorPorCodigo(emp.getCodigoUsuario()) != null) {
                    ProfessoresEx03 p = buscarProfessorPorCodigo(emp.getCodigoUsuario());
                    nomeUsuario = p.getNome();
                    isProfessor = true;
                }

                LocalDate dataEmprestimo = emp.getDataEmprestimo();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dataEmprestimoFormatada = dataEmprestimo.format(formatter);

                String dataDevolucaoFormatada = "";
                if (isProfessor) {
                    LocalDate dataPrevistaDevolucao = dataEmprestimo.plusDays(15);
                    dataDevolucaoFormatada += dataPrevistaDevolucao.format(formatter);
                } else {
                    LocalDate dataPrevistaDevolucao = dataEmprestimo.plusDays(7);
                    dataDevolucaoFormatada += dataPrevistaDevolucao.format(formatter);
                }

                int limiteDias = isProfessor ? 15 : 7;
                int diasEmprestado = java.time.Period.between(emp.getDataEmprestimo(), java.time.LocalDate.now()).getDays();

                String status;
                if (diasEmprestado > limiteDias) {
                    status = "Atrasado";
                } else {
                    status = "Dentro do prazo";
                }

                emprestimosAtivos += String.format(
                        "\nCódigo do livro: %s\n"
                        + "Título do livro: %s\n"
                        + "Atualmente em posse do usuário: %s\n"
                        + "Data do empréstimo: %s\n"
                        + "Data prevista para devolução: %s\n"
                        + "Dentro do prazo ou atrasado? %s\n\n",
                        emp.getLivro().getCodigoUnico(),
                        emp.getLivro().getTitulo(),
                        nomeUsuario,
                        dataEmprestimoFormatada,
                        dataDevolucaoFormatada,
                        status);
            }
        }

        if (emprestimosAtivos.isEmpty()) {
            return "Não há empréstimos ativos no momento";
        } else {
            return emprestimosAtivos;
        }
    }

    public String historicoUsuario(String codigo) {
        String resultado = "";
        String nomeUsuario = "";
        boolean isProfessor = false;

        if (buscarAlunoPorCodigo(codigo) != null) {
            AlunosEx03 a = buscarAlunoPorCodigo(codigo);
            nomeUsuario = a.getNome();
        }

        if (buscarProfessorPorCodigo(codigo) != null) {
            ProfessoresEx03 p = buscarProfessorPorCodigo(codigo);
            nomeUsuario = p.getNome();
            isProfessor = true;
        }

        if (nomeUsuario.isEmpty()) {
            return "Usuário não encontrado";
        }

        UsuarioEx03 u = new UsuarioEx03(codigo, nomeUsuario);
        int limiteDias = isProfessor ? 15 : 7;

        String historico = String.format("Histórico de empréstimos: %s\n%s", nomeUsuario, u.getEmprestimos());
        resultado += historico;

        int atrasos = 0;
        int devolvidosDepoisPrazo = 0;
        for (EmprestimoEx03 e : emprestimos) {
            if (e.getCodigoUsuario().equals(codigo)) {

                if (!e.isDevolvido()) {
                    int diasEmprestado = java.time.Period.between(e.getDataEmprestimo(), java.time.LocalDate.now()).getDays();

                    if (diasEmprestado > limiteDias) {
                        atrasos++;
                    }
                } else {
                    if (!e.isDevolvidoDentroPrazo()) {
                        devolvidosDepoisPrazo++;
                    }
                }

            }
        }

        if (atrasos > 0) {
            resultado += "Usuário possui pendências\n";
        }

        if (devolvidosDepoisPrazo > 0) {
            String depoisPrazo = String.format("Usuário devolveu %d livros depois do prazo", devolvidosDepoisPrazo);
            resultado += depoisPrazo;
        } else {
            resultado += "Usuário não há devoluções depois do prazo";
        }

        return resultado;
    }

}
