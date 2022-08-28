package sistemaBancario;
import java.io.*;


public class ContaPoupanca extends ContaBancaria {
	private double rendimento;
	private int saquesMensais;
	
	public ContaPoupanca(Pessoa novaPessoa, Banco novoBanco, int novoNroConta, double deposito, String novaSenha) {
		
		this.setTitular(novaPessoa);
		this.setBanco(novoBanco);
		this.setNroConta(novoNroConta);
		this.setSaldo(deposito);
		this.setSenha(novaSenha);
		
		this.setRendimento(5);
		this.setSaquesMensais(5);
	}
	
	@Override
	public void info() {
		System.out.println("Titutlar: " + this.getTitular().getNome() + " " + this.getTitular().getSobrenome());
		System.out.println("Banco: "); this.getBanco().infoBanco();
		System.out.println("Numero da conta" + this.getNroConta());
		System.out.println("Rendimentos ao mes: " + (this.getRendimento() * 100) + "%");
		System.out.println("Saques disponiveis: " + this.getSaquesMensais());
		
	}
	
	public void novoMes() {
		this.setSaldo(this.getSaldo() + (this.getSaldo() * this.getRendimento()));
		this.setSaquesMensais(5);
	}
	
	@Override
	public void saque(double valorSaque) throws IOException  {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		System.out.println("Digite a senha da conta: ");
		str = in.readLine();
		
		if(this.verificaSenha(str)) {
			if(this.getSaquesMensais() > 0) {
				if(this.getSaldo() >= valorSaque) {
					this.setSaldo(this.getSaldo() - valorSaque);
				} else {
					System.out.println("Saldo insuficiente para saque!");
				}
			} else {
				System.out.println("Você não possui saques disponiveis no momento");
			}
		} else {
			System.out.println("Senha incorreta");
		}
	}
	
	// getters e setters  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public void setRendimento(double novoRendimento) {
		this.rendimento = novoRendimento / 100;
	}
	
	public double getRendimento() {
		return this.rendimento;
	}
	
	public void setSaquesMensais(int novaCotaDeSaque) {
		this.saquesMensais = novaCotaDeSaque;
	}
	
	public int getSaquesMensais() {
		return this.saquesMensais;
	}
}
