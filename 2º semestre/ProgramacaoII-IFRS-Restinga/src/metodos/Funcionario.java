// feito por igor balest farias na aula de programação II do IFRS - restinga
package metodos;

public class Funcionario {
	String nome, sobrenome, cargo;
	float salario;
	String cpf;
	
	public Funcionario (String nome, String sobrenome, String cargo, float salario, String cpf) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cargo = cargo;
		this.salario = salario;
		this.cpf = cpf;
	}
	
	
	public void info() {
		System.out.println("Meu nome e "+ this.nome);
		System.out.println("Meu sobrenome "+ this.sobrenome);
		System.out.println("Cargo: "+ this.cargo);
		System.out.println("Salario: "+ this.salario);
		System.out.println("CPF: "+ this.cpf);
	}
	
	public void novoSalario(float novoSalario) {
		this.salario = novoSalario;
	}
	
	public void novoCargo(String novoCargo) {
		this.cargo = novoCargo;
	}
	
}
