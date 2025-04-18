public class AlunosEx03 extends UsuarioEx03 {
    private int idade;
    private String cursoMatriculado;
    private int numMatricula;

    public AlunosEx03(String codigoUnico, String nomeCompleto, int idade, String cursoMatriculado, int numMatricula) {
        super(codigoUnico, nomeCompleto);
        this.idade = idade;
        this.cursoMatriculado = cursoMatriculado;
        this.numMatricula = numMatricula;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCurso() {
        return cursoMatriculado;
    }

    public void setCurso(String cursoMatriculado) {
        this.cursoMatriculado = cursoMatriculado;
    }

    public int getMatricula() {
        return numMatricula;
    }

    public void setMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }
}