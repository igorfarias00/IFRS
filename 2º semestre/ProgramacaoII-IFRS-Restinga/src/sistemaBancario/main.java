package sistemaBancario;
import java.io.*;
import java.util.ArrayList;

public class main {
	public static void menu() {
		System.out.println("#########################################");
		System.out.println("1 - adicionar uma Pessoa. ");
		System.out.println("2 - adicionar um Banco. ");
		System.out.println("3 - adicionar uma Conta Corrente. ");
		System.out.println("4 - adicionar uma Conta Poupanca. ");
		System.out.println("5 - mostrar as contas de uma pessoa");
		System.out.println("6 - mostrar as contas de um banco");
		System.out.println("7 - pesquisar as informações de uma Pessoa");
		System.out.println("8 - pesquisar as informações de um Banco. ");
		System.out.println("#########################################");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		double deposito;
		String novoNome, novoSobrenome, novoCpf, novoCnpj, novaSenha;
		int opcao, novaIdade, novoNroBanco, novoNroConta;
		ArrayList<Banco> bancos = new ArrayList<Banco>();
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		/*//
		Pessoa p1 = new Pessoa("Romario", "Antunes madori", 14, "8959");
		Banco b1 = new Banco("Banco do Brasil", "4582909", 1);
		
		ContaCorrente contaC1 = new ContaCorrente(p1, b1, 5985, "TiaoMadeixas1999");
		contaC1.setBanco(b1);
		
		p1.addContaBancaria(contaC1);
		b1.addContaBancaria(contaC1);
		*/
		
		System.out.println();
	
		do {
			menu();
			opcao = Integer.parseInt(in.readLine());
			if(opcao == 1) { 		// adicionar uma pessoa
				// String novoNome,
				System.out.println("Digite o nome dessa pessoa: ");
				novoNome = in.readLine();

				// String novoSobrenome,
				System.out.println("Digite o sobrenome: ");
				novoSobrenome = in.readLine();
				
				// int novaIdade,
				do {
					System.out.println("Digite  a idade dessa pessoa: ");
					novaIdade = Integer.parseInt(in.readLine());
					if(novaIdade < 0) {
						System.out.println("Idade invalida, digite uma idade igual ou maior que Zero");
					}
				} while (novaIdade < 0);
				
				// String novoCpf
				
				System.out.println("Digite o cpf dessa pessoa: ");
				novoCpf = in.readLine();
				
				pessoas.add(new Pessoa(novoNome,novoSobrenome, novaIdade, novoCpf));
				
				
			} else if(opcao == 2) { // adicionar um banco
				//String novoNome,
				System.out.println("Digite o nome do Banco: ");
				novoNome = in.readLine();
				
				//String novoCNPJ,
				System.out.println("Digite o CNPJ do Banco: ");
				novoCnpj = in.readLine();
				
				//int novoNroBanco
				do {
					System.out.println("Digite o numero identificador do Banco: ");
					novoNroBanco = Integer.parseInt(in.readLine());
					if(novoNroBanco <= 0) {
						System.out.println("Numero invalido, digite um numero maior que zero");
					}
				} while(novoNroBanco <= 0);
				
				bancos.add(new Banco(novoNome, novoCnpj, novoNroBanco));
				
			} else if(opcao == 3) { // adicionar conta corrente
				//  Pessoa novoTitular,
				System.out.println("Digite o nome do Titular: ");
				novoNome = in.readLine();
				for(int i = 0; i < pessoas.size(); i++) {
					if(novoNome.compareToIgnoreCase((pessoas.get(i).getNome() + " " + pessoas.get(i).getSobrenome())) == 0) { 	// encontrou uma pessoa cadastrada 
						System.out.println("Digite o nome do Banco: ");
						novoNome = in.readLine();
						
						for(int j = 0; j< bancos.size(); j++) {
							if(novoNome.compareTo(bancos.get(i).getNome()) == 0) {			// encontrou um banco cadastrado
								System.out.println("Digite um numero para a conta: ");
								novoNroConta = Integer.parseInt(in.readLine());
								System.out.println("Defina a senha para a sua conta: ");
								novaSenha = in.readLine();
								
								ContaCorrente novaConta = new ContaCorrente(pessoas.get(i), bancos.get(j), novoNroConta, novaSenha);
								
								pessoas.get(i).addContaBancaria(novaConta);
								bancos.get(j).addContaBancaria(novaConta);
								break;
							} else {
								System.out.println("Banco não encontrado");
							}
						}
						break;
					} else {
						System.out.println("Pessoa nao encontrada");
					}
				}
				
				
				//  Banco novoBanco,
				//  int novoNroConta,
				//  String senha)
			} else if(opcao == 4) { // adicionar conta poupança
				//  Pessoa novoTitular,
				System.out.println("Digite o nome do Titular da conta poupanca: ");
				novoNome = in.readLine();
				for(int i = 0; i < pessoas.size(); i++) {
					if(novoNome.compareToIgnoreCase((pessoas.get(i).getNome() + " " + pessoas.get(i).getSobrenome())) == 0) { 	// encontrou uma pessoa cadastrada 
						System.out.println("Digite o nome do Banco: ");
						novoNome = in.readLine();
						
						for(int j = 0; j< bancos.size(); j++) {
							if(novoNome.compareTo(bancos.get(i).getNome()) == 0) {			// encontrou um banco cadastrado
								System.out.println("Digite um numero para a conta: ");
								novoNroConta = Integer.parseInt(in.readLine());
								System.out.println("Defina a senha para a sua conta: ");
								novaSenha = in.readLine();
								System.out.println("Digite o valor que ira depositar: ");
								deposito = Double.parseDouble(in.readLine());
								
								ContaPoupanca novaConta = new ContaPoupanca(pessoas.get(i), bancos.get(j), novoNroConta, deposito, novaSenha);
								
								pessoas.get(i).addContaBancaria(novaConta);
								bancos.get(j).addContaBancaria(novaConta);
								break;
								
							} else {
								System.out.println("Banco não encontrado");
							}
						}
						break;
					} else {
						System.out.println("Pessoa nao encontrada");
					}
				}
				
			} else if(opcao == 5) { // mostrar as contas de uma pessoa
				System.out.println("Digite um nome completo: ");
				novoNome = in.readLine();
				for(int i = 0; i < pessoas.size(); i++) {
					if(novoNome.compareToIgnoreCase((pessoas.get(i).getNome() + " " + pessoas.get(i).getSobrenome())) == 0) {
						pessoas.get(i).infoContas();
					} else {
						System.out.println("Pessoa não encontrada");
					}
				}
				
				
			} else if(opcao == 6) { // mostrar as contas de um banco
				System.out.println("Digite um nome do Banco: ");
				novoNome = in.readLine();
				for(int i = 0; i < bancos.size(); i++) {
					if(novoNome.compareToIgnoreCase(bancos.get(i).getNome()) == 0) {
						bancos.get(i).infoContas();
					} else {
						System.out.println("Banco não encontrado");
					}
				}
				
			} else if(opcao == 7) { // pesquisar as informações de uma pessoa
				System.out.println("Digite um nome completo: ");
				novoNome = in.readLine();
				for(int i = 0; i < pessoas.size(); i++) {
					if(novoNome.compareToIgnoreCase((pessoas.get(i).getNome() + " " + pessoas.get(i).getSobrenome())) == 0) {
						pessoas.get(i).info();
					} else {
						System.out.println("Pessoa não encontrada");
					}
				}
				
			} else if(opcao == 8) { // pesquisar as informações de um Banco 
				System.out.println("Digite um nome do Banco: ");
				novoNome = in.readLine();
				for(int i = 0; i < bancos.size(); i++) {
					if(novoNome.compareToIgnoreCase(bancos.get(i).getNome()) == 0) {
						bancos.get(i).infoBanco();
					} else {
						System.out.println("Banco não encontrado");
					}
				}
				
			} else if(opcao == 0) {
				System.out.println("Até mais!!!");
				
			} else {
				System.out.println("Opcao inválida!!!!");
			}
			
		} while (opcao != 0);
		
	/**	
		
		contaC1.info();
		System.out.println("Pessoa <<<<<<<<<<<<<<<<<<<<");
		p1.infoContas();
		
		System.out.println("Banco <<<<<<<<<<<<<<<<<<<<<");
		b1.infoContas();
		
	**/
	}
	
}
