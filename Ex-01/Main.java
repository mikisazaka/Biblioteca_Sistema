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
				
				break;
				
			}
			
			case 2: {
				
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
