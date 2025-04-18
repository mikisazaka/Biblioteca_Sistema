
import java.util.Scanner;

public class MainEx03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BibliotecaEx03 biblioteca = new BibliotecaEx03();

        while (true) {

            System.out.println("Escolha uma opção: ");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Remover usuário");
            System.out.println("3 - Exibir usuários cadastrados");
            System.out.println("4 - Exibir infomações específicas de cada usuário");
            System.out.println("5 - Cadastrar um livro no acervo");
            System.out.println("6 - Remover um livro do acervo");
            System.out.println("7 - Exibir livros cadastrados");
            System.out.println("8 - Realizar um empréstimo");
            System.out.println("9 - Registrar devolução de livro");
            System.out.println("10 - Listar empréstimos ativos");
            System.out.println("11 - Consultar o histórico de empréstimo de um usuário");
            System.out.println("12 - Sair");

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

                        AlunosEx03 aluno = new AlunosEx03(codigoUnico, nomeCompleto, idade, cursoMatriculado, numMatricula);
                        biblioteca.cadastro(aluno);

                    } else if (tipoUsuario == 2) {

                        System.out.println("Escreva a área de atuação do professor:");
                        String areaAtuacao = sc.nextLine();

                        System.out.println("Escreva o departamento do professor:");
                        String departamento = sc.nextLine();

                        System.out.println("Escreva o e-mail do professor:");
                        String email = sc.nextLine();

                        ProfessoresEx03 professor = new ProfessoresEx03(codigoUnico, nomeCompleto, areaAtuacao, departamento, email);
                        biblioteca.cadastro(professor);

                    } else {

                        System.out.println("Digite um número válido");

                    }

                    break;

                }

                case 2: {

                    System.out.println("Digite o código único do usuário a ser removido:");
                    int codigoUnico = Integer.parseInt(sc.nextLine());

                    if (biblioteca.remocao(codigoUnico)) {
                        System.out.println("Usuário removido com sucesso!");
                    } else {
                        System.out.println("Usuário não encontrado");
                    }

                    break;

                }

                case 3: {

                    System.out.println("Lista de alunos:");
                    for (AlunosEx03 a : biblioteca.getListaAlunos()) {
                        System.out.println(a.exibirDados());
                    }

                    System.out.println("Lista de professores:");
                    for (ProfessoresEx03 p : biblioteca.getListaProfessores()) {
                        System.out.println(p.exibirDados());
                    }

                    break;

                }

                case 4: {

                    System.out.println("Lista de alunos (informaçõess específicas):");
                    for (AlunosEx03 a : biblioteca.getListaAlunos()) {
                        System.out.println(a.exibirDadosEspecificos());
                    }

                    System.out.println("Lista de professores (informaçõess específicas):");
                    for (ProfessoresEx03 p : biblioteca.getListaProfessores()) {
                        System.out.println(p.exibirDadosEspecificos());
                    }

                    break;

                }

                case 5: {

                    System.out.println("Qual o tipo de livro deseja cadastrar? ");
                    System.out.println("1 - Livro Físico");
                    System.out.println("2 - E-book");
                    System.out.println("3 - Audiobook");

                    int tipoDeLivro = Integer.parseInt(sc.nextLine());

                    System.out.println("Informe o código único do livro ");
                    String codigoUnico = sc.nextLine();

                    System.out.println("Informe o título do livro ");
                    String tituloLivro = sc.nextLine();

                    System.out.println("Informe o autor do livro ");
                    String autorLivro = sc.nextLine();

                    if (tipoDeLivro == 1) {

                        System.out.println("Informe o número de páginas ");
                        int numeroDePaginas = Integer.parseInt(sc.nextLine());

                        System.out.println("Por último, informe em qual estante está localizado ");
                        int estante = Integer.parseInt(sc.nextLine());

                        LivrosEx03 livros = new LivroFisicoEx03(codigoUnico, tituloLivro, autorLivro, numeroDePaginas, estante);
                        biblioteca.cadastrarLivro(livros);

                    } else if (tipoDeLivro == 2) {

                        System.out.println("Informe o número de páginas ");
                        int numeroDePaginas = Integer.parseInt(sc.nextLine());

                        System.out.println("Por último, informe o link para download ");
                        String linkDownload = sc.nextLine();

                        LivrosEx03 ebook = new EbookEx03(codigoUnico, tituloLivro, autorLivro, numeroDePaginas, linkDownload);
                        biblioteca.cadastrarLivro(ebook);

                    } else if (tipoDeLivro == 3) {

                        System.out.println("Informe a duração do aúdio(min) ");
                        int duracaoDoAudio = Integer.parseInt(sc.nextLine());

                        System.out.println("Por último, informe o nome do narrador ");
                        String nomeNarrador = sc.nextLine();

                        LivrosEx03 audioBook = new AudioBookEx03(codigoUnico, tituloLivro, autorLivro, duracaoDoAudio, nomeNarrador);
                        biblioteca.cadastrarLivro(audioBook);

                    } else {
                        System.out.println("Tipo de livro inexistente, por favor selecione uma das opções disponíveis.");
                    }
                    break;

                }

                case 6: {

                    System.out.println("Digite o código único do livro que deseja remover do sistema: ");
                    String codigoUnico = sc.nextLine();

                    if (biblioteca.removerLivro(codigoUnico)) {
                        System.out.println("Livro removido com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado com o código: " + codigoUnico);
                    }
                    break;

                }

                case 7: {

                    System.out.println("\n=== LIVROS CADASTRADOS ===");
                    System.out.println("" + biblioteca.obterInformacoesLivros());

                }

                case 8: {

                    System.out.println("Informe o código do livro que deseja retirar");

                    break;

                }

                case 9: {

                    break;

                }

                case 10: {

                    break;

                }

                case 11: {

                    break;

                }

                case 12: {
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
