package sistemaBancario;

public class ContaCorrente extends ContaBancaria{
	private double taxasMensais;
	
	public ContaCorrente( Pessoa novoTitular, 
						  Banco novoBanco,
						  int novoNroConta,
						  String senha) {
		this.setTitular(novoTitular);
		this.setBanco(novoBanco);
		this.setNroConta(novoNroConta);
		this.setSenha(senha);
		this.setTaxasMensais(5.0);
	}
	
	
	
	public void novoMes() {
		if(this.getSaldo() >= this.getTaxasMensais()) {
			this.setSaldo(this.getSaldo() - this.getTaxasMensais());
		} else {
			System.out.println("Saldo insuficiente para descontar a taxa de manutenção da conta.");
			System.out.println("Sua conta será congelada em 5 dias!!!");
		}
	}
	
	@Override
	public void info() {
		System.out.println("Titutlar: " + this.getTitular().getNome() + " " + this.getTitular().getSobrenome());
		System.out.println("Banco: "); this.getBanco().infoBanco();
		System.out.println("Numero da conta" + this.getNroConta());
		System.out.println("Taxas mensais: " + this.getTaxasMensais());
		
	}
	
	
	// getters e setters <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public void setTaxasMensais(double novaTaxa) {
		this.taxasMensais = novaTaxa;
	}
	
	public double getTaxasMensais() {
		return this.taxasMensais;
	}
}
