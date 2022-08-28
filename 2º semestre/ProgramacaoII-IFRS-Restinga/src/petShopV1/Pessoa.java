 package petShopV1;
 import java.util.ArrayList;

public class Pessoa {
	private String nome_completo;
	private int cpf;
	private String endereco;
	private String email;
	private ArrayList<Integer> telefones = new ArrayList<>();
	
	
	public Pessoa(	String novoNome, 
					int novoCpf, 
					String novoEndereco, 
					String novoEmail, 
					int novoTelefone) {
		this.setNome_completo(novoNome);
		this.setCpf(novoCpf);
		this.setEndereco(novoEndereco);
		this.setEmail(novoEmail);
		this.addTelefones(novoTelefone);
		
	}
	
	public String info_pessoa() {
		String str ="";
		str += "Nome: " + this.getNome_completo() + "\n";
		str += "Cpf: " + this.getCpf() + "\n";	
		str += "Endereco: " + this.getEndereco() + "\n";	

		return str;
	} 
	
	public String info_contato() {
		String str = "";
		
		str += "Email: " + this.getEmail() + "\n";	
		str += "Telefones: ";
		for(int i= 0; i< this.telefones.size(); i++) {
			str += telefones.get(i) + "\n";
			str += "\t   ";
		}
		
		return str;
	}
	
	
	
	
	// getter e setter <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public String getNome_completo() {
		return this.nome_completo;
	}
	
	public void setNome_completo(String novoNome) {
		this.nome_completo = novoNome;
	}
	
	public int getCpf() {
		return this.cpf;
	}
	
	public void setCpf(int novoCpf) {
		this.cpf = novoCpf;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String novoEndereco) {
		this.endereco = novoEndereco;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String novoEmail) {
		this.email = novoEmail;
	}
	
	public int getTelefones(int indice) {
		return this.telefones.get(indice);
	}
	
	public void setTelefones(int indice, int telefone) {
		this.telefones.set(indice, telefone);
	}
	
	public void addTelefones(int novoTelefone) {
		this.telefones.add(novoTelefone);
	}
	
}
