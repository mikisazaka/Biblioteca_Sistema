
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Alunos> listaAlunos;
    private ArrayList<Professores> listaProfessores;

    public Biblioteca() {
        this.listaAlunos = new ArrayList<>();
        this.listaProfessores = new ArrayList<>();
    }

    public boolean cadastro(Alunos aluno) {
        if(aluno != null) {
            listaAlunos.add(aluno);
            return true;
        } else {
            return false;
        }
    }

    public boolean cadastro(Professores professor) {
        if(professor != null) {
            listaProfessores.add(professor);
            return true;
        } else {
            return false;
        }
    }

    public boolean remocao(int codigo) {
        for (Alunos a : listaAlunos) {
            if (a.getCodigo() == codigo) {
                listaAlunos.remove(a);
                return true;
            }
        }

        for (Professores p : listaProfessores) {
            if (p.getCodigo() == codigo) {
                listaProfessores.remove(p);
                return true;
            }
        }

        return false;
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
