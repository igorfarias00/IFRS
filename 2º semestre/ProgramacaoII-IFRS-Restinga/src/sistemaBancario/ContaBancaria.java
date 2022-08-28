package sistemaBancario;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class ContaBancaria {
	protected Pessoa titular;
	protected Banco banco;
	protected int nroConta;
	protected double saldo;
	protected String senha;
	
	public void saque(double valorSaque) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		System.out.println("Digite a senha da conta: ");
		str = in.readLine();
		
		if(this.verificaSenha(str)) {
			if(this.getSaldo() >= valorSaque) {
				this.setSaldo(this.getSaldo() - valorSaque);
			} else {
				System.out.println("Saldo insuficiente para saque");
			}
		} else {
			System.out.println("Senha incorreta");
		}
	}
	
	public void deposito(double valorDeposito) {
		this.setSaldo(this.getSaldo() + valorDeposito);
		
	}
	
	public boolean verificaSenha(String senhaDigitada) {
		if(senhaDigitada.equals(this.getSenha())) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public void info() {
		
	}
	
	// gettters e setters <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	//Pessoa titular;
	
	public Pessoa getTitular() {
		return this.titular;
	}
	
	public void setTitular(Pessoa novoTitular) {
		this.titular = novoTitular;
	}
	
	public Banco getBanco() {
		return this.banco;
	}
	
	public void setBanco(Banco novoBanco) {
		this.banco = novoBanco;
	}
	
	public int getNroConta() {
		return this.nroConta;
	}
	
	public void setNroConta(int novoNroConta) {
		this.nroConta = novoNroConta;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public void setSaldo(double novoSaldo) {
		this.saldo = novoSaldo;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String novaSenha) {
		this.senha = novaSenha;
	}
}
