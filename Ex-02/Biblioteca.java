
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Alunos> listaAlunos;
	private ArrayList<Professores> listaProfessores;
	
	public Biblioteca() {
	    this.listaAlunos = new ArrayList<>();
		this.listaProfessores = new ArrayList<>();
	}

	public ArrayList<Alunos> getListaAlunos() {
        return listaAlunos;
    }

    public void setListaAlunos(ArrayList<Alunos> listaAlunos) {
        this.listaAlunos = listaAlunos;
    }

	public ArrayList<Professores> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(ArrayList<Professores> listaProfessores) {
        this.listaProfessores = listaProfessores;
    }
}