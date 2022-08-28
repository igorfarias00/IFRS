package sistemaBancario;
import java.util.List;
import java.util.ArrayList;

public class Banco {
	private String Nome;
	private String CNPJ;
	private int NroBanco;	
	private ArrayList<ContaBancaria> contasBancarias = new ArrayList<ContaBancaria>();
	
	public Banco(String novoNome,
				 String novoCNPJ,
				 int novoNroBanco) {
		this.setNome(novoNome);
		this.setCNPJ(novoCNPJ);
		this.setNroBanco(novoNroBanco);
	}
	
	public void infoBanco() {
		String str = "";
		str += "Nome: " + this.getNome() +"\n";
		str += "CNPJ: " + this.getCNPJ() + "\n";
		str += "Numero do Banco: " + this.getNroBanco() + "\n";
		System.out.println(str);
	}
	
	public void infoContas() {	
		
		for(int i = 0; i < this.contasBancarias.size(); i++) {
			this.getContaBancaria(i).info();
		}
		
	}
	
	public void CriarConta() {
		
	}
	
	public void FecharConta() {
		
	}

	
	// getters e setters <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public String getNome() {
		return this.Nome;
	}

	public void setNome(String nome) {
		this.Nome = nome;
	}

	public String getCNPJ() {
		return this.CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		this.CNPJ = cNPJ;
	}

	public int getNroBanco() {
		return this.NroBanco;
	}

	public void setNroBanco(int nroBanco) {
		this.NroBanco = nroBanco;
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
