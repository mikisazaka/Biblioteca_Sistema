import java.util.ArrayList;

public class BibliotecaEx03 {
    private ArrayList<AlunosEx03> listaAlunos;
	private ArrayList<ProfessoresEx03> listaProfessores;
    private ArrayList<LivrosEx03> livros = new ArrayList<>();
	
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

    public boolean cadastrarLivro(LivrosEx03 livros) {
        if (livros != null) {
            this.livros.add(livros);
            return true; 
        } else{
            return false;
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
}
