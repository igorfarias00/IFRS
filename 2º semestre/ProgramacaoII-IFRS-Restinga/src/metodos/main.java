// feito por igor balest farias na aula de programação II do IFRS - restinga
package metodos;

public class main {
	public static void main(String[] args) {
//		Pessoa pessoas[];
//		pessoas = new Pessoa[3];
//		for (int i = 0; i < 3; i++) {
//			pessoas[i] = new Pessoa("igor", "farias", 24);
//		}
//		
//		pessoas[0].info();

		
		Empresa empresas[];
		empresas = new Empresa[3];
		for (int i = 0; i < 3; i++) {
			empresas[i] = new Empresa("GKN","999.999.999-9", "rua 15 de novembro", "industria");
		}
		
		Remedio remedios[];
		remedios = new Remedio[3];
		for (int i = 0; i < 3; i++) {
			remedios[i] = new Remedio("ritalina", "Preta", "bayer", 30.5, 50);
		}
			
		Funcionario funcionarios[];
		funcionarios = new Funcionario[3];
		for (int i = 0; i < 3; i++) {
			funcionarios[i] = new Funcionario("vitor", "flores", "dev", 666, "99999999901");
		}
		
		
		Livro livros[] = new Livro[3];
		for (int i = 0; i < 3; i++) {
			livros[i] = new Livro("Dom quixote", "intrinseca", "Servantes", 9999999, 85, 97.50);
		}
		
		
		livros[0].titulo = "Dom quixote";
		livros[1].titulo = "20 mil leguas submarinas";
		livros[2].titulo = "os Sertões";
		
		System.out.println("###---------## empresas ## --------------##");
		
		for (int i = 0; i < 3; i++) {
			System.out.println("******----**"+ (i +1) + "**----*******");
			empresas[i].info();
			System.out.println();

		}
		
		System.out.println("###---***----## remedios ##-------***-------##");
		
		for (int i = 0; i < 3; i++) {
			System.out.println("******----**"+ (i +1) + "**----*******");
			remedios[i].info();
			System.out.println();
			
		}
		
		System.out.println("###--------## funcionarios ## -----------##");
		
		for (int i = 0; i < 3; i++) {
			System.out.println("******----**"+ (i +1) + "**----*******");
			funcionarios[i].info();
			System.out.println();

		}
		
		System.out.println("### -------## livros ## ---------------##");
		
		for (int i = 0; i < 3; i++) {
			System.out.println("******----**"+ (i +1) + "**----*******");
			livros[i].info();
			System.out.println();

		}
		
		remedios[0].info();
		remedios[0].novoEstoque(999);
		remedios[0].novoValor(50);
		remedios[0].decrementaEstoque(20);
		remedios[0].info();
		
		livros[0].info();
		livros[0].novoEstoque(500);
		livros[0].novoValor(200);
		livros[0].info();
		
		funcionarios[0].info();
		funcionarios[0].novoCargo("Gerente");
		funcionarios[0].novoSalario(30000);
		funcionarios[0].info();
		
		empresas[0].info();
		empresas[0].novoEndereco("Rua das alamendas, 100");
		empresas[0].info();
		
		
	}
}
