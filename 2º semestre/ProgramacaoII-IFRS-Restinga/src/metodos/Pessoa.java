package metodos;

public class Pessoa {
	String nome, sobrenome, cpf;
	int idade;
	Pessoa pai, mae;
	
	public Pessoa(String nome, String sobrenome, int idade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.idade = idade;
		
	}
	
	public void info() {
		System.out.println("Meu nome e "+ this.nome);
		System.out.println("Meu sobrenome "+ this.sobrenome);
		System.out.println("Minha idade e "+ this.idade);
		System.out.println("Meu cpf e "+ this.cpf);
	}
}
