 package sistemaBancario;
 import java.util.ArrayList;

public class Pessoa {
	public String nome;
	public String sobrenome;
	public int idade;
	private String cpf;
	private ArrayList<ContaBancaria> contasBancarias = new ArrayList<ContaBancaria>();
	
	
	public Pessoa(	String novoNome, 
					String novoSobrenome,
					int novaIdade,
					String novoCpf					) {
		this.setNome(novoNome);
		this.setSobrenome(novoSobrenome);
		this.setCpf(novoCpf);
		this.setIdade(novaIdade);


		
	}
	
	public void info() {
		String str ="";
		str += "Nome: " + this.getNome() + " " + this.getSobrenome() + "\n";
		str += "Cpf: " + this.getCpf() + "\n";	
		str += "Idade: " + this.getIdade() + "\n";
 
		System.out.println(str);
	} 
	
	public void infoContas() {
		String str = "Contas: ";
		
		for(int i = 0; i < contasBancarias.size(); i++) {
			this.getContaBancaria(i).info();
			
		}
		
	}
	
	
	
	
	// getter e setter <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public String getSobrenome() {
		return this.sobrenome;
	}
	
	public void setSobrenome(String novoSobrenome) {
		this.sobrenome = novoSobrenome;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public void setIdade(int novaIdade) {
		this.idade = novaIdade;
	}
	
	public String getCpf() {
		return this.cpf;
	}
	
	public void setCpf(String novoCpf) {
		this.cpf = novoCpf;
	}
	
	public ContaBancaria getContaBancaria(int indice) {
		return this.contasBancarias.get(indice);
	}
	
	public void setContaBancaria(int indice, ContaBancaria novaConta) {
		this.contasBancarias.set(indice, novaConta);
	}
	
	public void addContaBancaria(ContaBancaria novaConta) {
		this.contasBancarias.add(novaConta);
	}

	
}
