
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Alunos> listaAlunos;
    private ArrayList<Professores> listaProfessores;

    public Biblioteca() {
        this.listaAlunos = new ArrayList<>();
        this.listaProfessores = new ArrayList<>();
    }

    public void cadastro(Alunos aluno) {
        listaAlunos.add(aluno);
    }

    public void cadastro(Professores professor) {
        listaProfessores.add(professor);
    }

    public void remocao(int codigo) {
        for (Alunos a : listaAlunos) {
            if (a.getCodigo() == codigo) {
                listaAlunos.remove(a);
                break;
            }
        }

        for (Professores p : listaProfessores) {
            if (p.getCodigo() == codigo) {
                listaProfessores.remove(p);
                break;
            }
        }
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
