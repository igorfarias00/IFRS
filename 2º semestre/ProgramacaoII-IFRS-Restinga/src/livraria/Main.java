/* perguntas a fazer:
 * o ArrayList deveria estar no objeto?
 * metodos estaticos e nao estaticos no main
 * 
 *  Código feito por igor balest farias, para a cadeira de programação II do IFRS - campus restinga
 * 
 * 
 */
package livraria;


import java.util.Scanner;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		int menu = 0, pos = 0;
		String titulo, editora, area;
		double preco;
		ArrayList<Livros> livros = new ArrayList<>();
		Scanner tcl = new Scanner(System.in);
		
		
		livros.add(new Livros("20 mil leguas", "aleph", "sci-fi", 1869, 99.59));
		

	
		do {
			menu();
			menu = tcl.nextInt();
			switch(menu) {
				case 1: tcl.nextLine();
;						System.out.println("digite o titulo do livro: \n");
						titulo = tcl.nextLine();
						//tcl.nextLine();
						System.out.print("Digite o nome da editora: \n");
						editora = tcl.nextLine();
						System.out.println("Digite a categoria do livro: ");
						area = tcl.nextLine();
						System.out.println("Digite o ano do livro");
						int ano = tcl.nextInt();
						System.out.println("Digite o valor do livro: ");
						double valor = tcl.nextDouble();
						
						livros.add(new Livros(titulo, editora, area, ano, valor));
						
					break;
				case 2:	for(int i = 0; i < livros.size();i++) {
							livros.get(i).apresentaLivro();
						}
					break;
						
				case 3: tcl.nextLine();
						System.out.println("Digite o Titulo que você deseja buscar: ");
						titulo = tcl.nextLine();
						System.out.println(titulo);
						for(int i = 0; i < livros.size();i++) {
							System.out.println(livros.get(i).buscaPorTitulo(titulo));
							if(livros.get(i).buscaPorTitulo(titulo)) {
								pos++;
								livros.get(i).apresentaLivro();
							} 
						}
						if (pos == 0) {
							System.out.println("Livro não encontrado!");
						} else {
							pos = 0;
						}
					break;
						
				case 4: System.out.println("Digite a categoria que você deseja buscar: ");
						area = tcl.nextLine();
						for(int i = 0; i < livros.size();i++) {
							if(livros.get(i).buscaPorArea(area)) {
								pos++;
								livros.get(i).apresentaLivro();
							} 
						}
						if (pos == 0) {
							System.out.println("Não temos livros nesta categoria!");
						} else {
							pos = 0;
						}
					break;
					
				case 5: System.out.println("Digite o preco que você deseja buscar: ");
						preco = tcl.nextDouble();
						for(int i = 0; i < livros.size();i++) {
							if(livros.get(i).buscaPorPreco(preco)) {
								pos++;
								livros.get(i).apresentaLivro();
							} 
						}
						if (pos == 0) {
							System.out.println("Não temos livros nesta faixa de preço");
						} else {
							pos = 0;
						}
					break;
				
				case 0: System.out.println("ATÈ MAIS!!!");
				 	break;
				 	
					default: System.out.println("você digitou uma opção inválida");
				
			}
		} while (menu != 0);
		
	}
	
	public static void menu() {
		System.out.println(
				  "1 – Cadastrar novo livro \r\n"
				+ "2 – Listar livros \r\n"
				+ "3 – Buscar livros por nome \r\n"
				+ "4 – Buscar livros por categoria \r\n"
				+ "5 – Buscar livros por preço \r\n"
				+ "0 – Encerrar atividades");
		
	}
	
	
}
