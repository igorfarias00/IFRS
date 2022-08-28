package metodos;

public class Empresa {
	String nome, cnpj, endereco, servico;
	
	
	public Empresa(String nome, String cnpj, String endereco, String servico) {
		this.nome= nome;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.servico = servico;
	}
	
	public void info() {
		System.out.println("Meu nome e "+ this.nome);
		System.out.println("CNPJ:  "+ this.cnpj);
		System.out.println("Endereco: "+ this.endereco);
		System.out.println("servico: "+ this.servico);
	}
	
	public void novoEndereco(String endereco) {
		this.endereco = endereco;
	}
}
