
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {

            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Remover usuário");
            System.out.println("3 - Exibir usuários cadastrados");
            System.out.println("4 - Exibir infomações específicas de cada usuário");
            System.out.println("5 - Sair");

            int opcao = Integer.parseInt(sc.nextLine());

            switch (opcao) {

                case 1: {

                    System.out.println("Deseja resgistrar um aluno ou professor? Digite 1 para aluno e 2 para professor");
                    int tipoUsuario = Integer.parseInt(sc.nextLine());

                    System.out.println("Digite o código único do usuário:");
                    int codigoUnico = Integer.parseInt(sc.nextLine());

                    System.out.println("Escreva o nome completo do usuário:");
                    String nomeCompleto = sc.nextLine();

                    if (tipoUsuario == 1) {

                        System.out.println("Digite a idade do aluno:");
                        int idade = Integer.parseInt(sc.nextLine());

						System.out.println("Escreva o curso em que o aluno está matriculado:");
                        String cursoMatriculado = sc.nextLine();

						System.out.println("Digite o número de matrícula do aluno:");
                        int numMatricula = Integer.parseInt(sc.nextLine());

						Alunos aluno = new Alunos(codigoUnico, nomeCompleto, idade, cursoMatriculado, numMatricula);
                        biblioteca.cadastro(aluno);
                        System.out.println("Aluno cadastrado com sucesso!");

                    } else if (tipoUsuario == 2) {

						System.out.println("Escreva a área de atuação do professor:");
                        String areaAtuacao = sc.nextLine();

						System.out.println("Escreva o departamento do professor:");
                        String departamento = sc.nextLine();

						System.out.println("Escreva o e-mail do professor:");
                        String email = sc.nextLine();

						Professores professor = new Professores(codigoUnico, nomeCompleto, areaAtuacao, departamento, email);
                        biblioteca.cadastro(professor);
                        System.out.println("Professor cadastrado com sucesso!");

                    } else {

                        System.out.println("Digite um número válido");

                    }

                    break;

                }

                case 2: {

                    System.out.println("Digite o código único do usuário a ser removido:");
                    int codigoUnico = Integer.parseInt(sc.nextLine());

                    biblioteca.remocao(codigoUnico);

                    break;

                }

                case 3: {

                    System.out.println("Lista de alunos:");
                    for(Alunos a : biblioteca.getListaAlunos()) {
                        System.out.println(a.exibirDados());
                    }

                    System.out.println("Lista de professores:");
                    for(Professores p : biblioteca.getListaProfessores()) {
                        System.out.println(p.exibirDados());
                    }

                    break;

                }

                case 4: {

                    System.out.println("Lista de alunos (informaçõess específicas):");
                    for(Alunos a : biblioteca.getListaAlunos()) {
                        System.out.println(a.exibirDadosEspecificos());
                    }

                    System.out.println("Lista de professores (informaçõess específicas):");
                    for(Professores p : biblioteca.getListaProfessores()) {
                        System.out.println(p.exibirDadosEspecificos());
                    }

                    break;

                }

                case 5: {
                    sc.close();
                    return;
                }

                default: {
                    System.out.println("Entrada inválida");
                }

            }

        }
    }

}
