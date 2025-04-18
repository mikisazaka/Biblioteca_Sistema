import java.util.Scanner;

public class MainLivros {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BibliotecaLivros biblioteca = new BibliotecaLivros();
		
		while (true) {
			
			System.out.println("Escolha uma opção: ");
			System.out.println("1 - Cadastrar um livro no acervo");
			System.out.println("2 - Remover um livro do acervo");
			System.out.println("3 - Exibir livros cadastrados");
			System.out.println("4 - Sair");
			
			int opcao = Integer.parseInt(sc.nextLine());
			
			switch (opcao) {
			case 1: {
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

				if(tipoDeLivro == 1) {

					System.out.println("Informe o número de páginas ");
					int numeroDePaginas = Integer.parseInt(sc.nextLine());

					System.out.println("Por último, informe em qual estante está localizado ");
					int estante = Integer.parseInt(sc.nextLine());

					Livros livros = new LivroFisico(codigoUnico, tituloLivro, autorLivro, numeroDePaginas, estante); 
					biblioteca.cadastrarLivro(livros);

				} else if(tipoDeLivro == 2) {

					System.out.println("Informe o número de páginas ");
					int numeroDePaginas = Integer.parseInt(sc.nextLine());

					System.out.println("Por último, informe o link para download ");
					String linkDownload = sc.nextLine();

					Livros ebook = new Ebook(codigoUnico, tituloLivro, autorLivro, numeroDePaginas, linkDownload);
					biblioteca.cadastrarLivro(ebook);

				} else if(tipoDeLivro == 3) {

					System.out.println("Informe a duração do aúdio(min) ");
					int duracaoDoAudio = Integer.parseInt(sc.nextLine());

					System.out.println("Por último, informe o nome do narrador ");
					String nomeNarrador = sc.nextLine();

					Livros audioBook = new AudioBook(codigoUnico, tituloLivro, autorLivro, duracaoDoAudio, nomeNarrador);
					biblioteca.cadastrarLivro(audioBook);

				} else {
					System.out.println("Tipo de livro inexistente, por favor selecione uma das opções disponíveis.");
								}
				break;
			}
			
			case 2: {
				System.out.println("Digite o código único do livro que deseja remover do sistema: ");
				String codigoUnico = sc.nextLine();
				
				if (biblioteca.removerLivro(codigoUnico)) {
					System.out.println("Livro removido com sucesso!");
				} else {
					System.out.println("Livro não encontrado com o código: " + codigoUnico);
				}
				break;
			}
			
			case 3: {

   				System.out.println("\n=== LIVROS CADASTRADOS ===");
				System.out.println("" + biblioteca.obterInformacoesLivros());

   			 break;
			}
			
			case 4: {
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
