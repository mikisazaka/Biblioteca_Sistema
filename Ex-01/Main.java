import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Biblioteca biblioteca = new Biblioteca();
		
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

				if(tipoDeLivro == 1) {

				} else if(tipoDeLivro == 2) {

				} else if(tipoDeLivro == 3) {

				} else {
					System.out.println("Tipo de livro inexistente, por favor selecione uma das opções disponíveis.");
								}
				break;
				
			}
			
			case 2: {
				
				System.out.println("Digite o código único do livro que deseja remover do sistema: ");

				String codigoUnico = sc.nextLine();

				break;
				
			}
			
			case 3: {
				
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
