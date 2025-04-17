
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
				
				break;
				
			}
			
			case 2: {
				
				break;
				
			}
			
			case 3: {
				
				break;
				
			}
			
			case 4: {
				
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