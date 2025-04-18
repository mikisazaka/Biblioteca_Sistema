import java.util.ArrayList;

public class BibliotecaLivros {
    private ArrayList<Livros> livros = new ArrayList<>();

    public BibliotecaLivros() {
        this.livros = new ArrayList<>();
    }

    public ArrayList<Livros> getListaLivros() {
        return livros;
    }

    public void setListaLivros(ArrayList<Livros> listaLivros) {
        this.livros = listaLivros;
    }

    public boolean cadastrarLivro(Livros livros) {
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
        for (Livros livro : livros) {
            resultado += livro.exibirInfo() + "\n";
        }
        return resultado;
    }

    public Livros buscarLivro(String codigoUnico) {
        for(Livros livro : livros) {
            if(livro.getCodigoUnico().equals(codigoUnico)) {
                return livro;
            }
        }
        return null;
    }

    public boolean removerLivro(String codigoUnico) {
        Livros livroParaRemover = buscarLivro(codigoUnico);
        if (livroParaRemover != null) {
            livros.remove(livroParaRemover);
            return true;
        }
        return false;
    }
}
