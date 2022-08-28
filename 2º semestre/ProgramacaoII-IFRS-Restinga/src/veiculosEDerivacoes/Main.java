package veiculosEDerivacoes;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



public class Main {
	public static void menu(int opcao){
		if(opcao == 99) {
			System.out.println("***** - Bem vindo ao cadastro de veiculos universal! - ***");
			System.out.println("**\t Seleciona o que deseja: \t\t\t**");
			System.out.println("**\t 1 - Cadastrar novo Veiculo.\t\t\t**");
			System.out.println("**\t 2 - Mostrar todos Veiculos cadastrados. \t**");
			System.out.println("**\t 3 - Mostrar um veiculo cadastrado. \t\t**");
			System.out.println("**\t 4 - atualizar a posição de um veiculo. \t**");
			System.out.println("**\t 55 - Mostrar a posição do veiculo.\t\t**");
			System.out.println("**\t 0 - Sair. \t\t\t\t\t**");
			System.out.println("**********************************************************");
			System.out.printf("========>");
		} else if(opcao == 1) {
			System.out.println("**\t Cadastrar Novo Veiculo: \t\t\t**");
			System.out.println("**\t 5 - Terrestre.\t\t\t\t\t**");
			System.out.println("**\t 6 - Maritmo. \t\t\t\t\t**");
			System.out.println("**\t 7 - Aereo. \t\t\t\t\t**");
			System.out.println("**\t 0 - Sair. \t\t\t\t\t**");
			System.out.println("**********************************************************");
			System.out.printf("========>");
		} else if(opcao == 5) {
			System.out.println("**\t Cadastrar Novo Veiculo Terrestre: \t\t**");
			System.out.println("**\t 8 - Carro.\t\t\t\t\t**");
			System.out.println("**\t 9 - Moto. \t\t\t\t\t**");
			System.out.println("**\t 10 - Caminhão. \t\t\t\t\t**");
			System.out.println("**\t 0 - Sair. \t\t\t\t\t**");
			System.out.println("**********************************************************");
			System.out.printf("========>");
		} else if(opcao == 7) {
			System.out.println("**\t Cadastrar Novo Veiculo Aereo: \t\t\t**");
			System.out.println("**\t 11 - Helicoptero.\t\t\t\t**");
			System.out.println("**\t 12 - Aviao. \t\t\t\t\t**");
			System.out.println("**\t 0 - Sair. \t\t\t\t\t**");
			System.out.println("**********************************************************");
			System.out.printf("========>");
		} else if(opcao == 6) {
			System.out.println("**\t Cadastrar Novo Veiculo Maritmo: \t\t**");
			System.out.println("**\t 13 - Submarino.\t\t\t\t\t**");
			System.out.println("**\t 14 - Navio. \t\t\t\t\t**");
			System.out.println("**\t 0 - Sair. \t\t\t\t\t**");
			System.out.println("**********************************************************");
			System.out.printf("========>");
		}
		
	}
	
	public static void main(String[] args) {
		int opcao, i, x, y, z;
		String fabricante, modelo,  pais,  novoDono, classe, nome, tipo;
		double valor;
		int passageiros, anoFab, potencia, combustivel, rotores;
		
		Scanner tcl = new Scanner(System.in);
		ArrayList<Veiculo> veiculos = new ArrayList();
		opcao = 99;
		
		veiculos.add(new Submarino("Tridente", "SeaHorse", "British", 995000, 25, 2015, "Tiao viagens maritmas", 500));
		veiculos.add(new Carro("Volkswagen","uno", "japones", 14000, 4, 1897, "Joao pessoa", 500, "SUV", 50));
		
		veiculos.get(0).info();		
		veiculos.get(1).info();
		System.out.println(veiculos.get(0).getClass());
		
		do {
			menu(opcao);
			opcao = tcl.nextInt();
			if(opcao == 6) {											// Carro +++++++++++++++++++++++++++++++++++++++++++++++
				System.out.println("Digite o fabricante do Carro: ");
				fabricante = tcl.next();
				System.out.println("Digite o modelo: ");
				modelo = tcl.next();
				System.out.println("Digite o país de origem: ");
				pais = tcl.next();
				System.out.println("valor : ");
				valor = tcl.nextDouble();
				System.out.println("Quantidade de passageiros: ");
				passageiros = tcl.nextInt();
				System.out.println("Ano de fabricação: ");
				anoFab = tcl.nextInt();
				System.out.println("Nome do proprietario: ");
				novoDono = tcl.next();
				System.out.println("potencia: ");
				potencia = tcl.nextInt();
				System.out.println("Classe: ");
				classe = tcl.next();
				System.out.println("Tamanho do tanque de combustivel: ");
				combustivel = tcl.nextInt();
				
				veiculos.add(new Carro(fabricante, modelo, pais, valor, passageiros, anoFab, novoDono, potencia, classe, combustivel));
			} else if (opcao == 7) {									// Moto +++++++++++++++++++++++++++++++++++++++++++++
				System.out.println("Digite o fabricante do Carro: ");
				fabricante = tcl.next();
				System.out.println("Digite o modelo: ");
				modelo = tcl.next();
				System.out.println("Digite o país de origem: ");
				pais = tcl.next();
				System.out.println("valor : ");
				valor = tcl.nextDouble();
				System.out.println("Quantidade de passageiros: ");
				passageiros = tcl.nextInt();
				System.out.println("Ano de fabricação: ");
				anoFab = tcl.nextInt();
				System.out.println("Nome do proprietario: ");
				novoDono = tcl.next();
				System.out.println("Cilindrada: ");
				potencia = tcl.nextInt();
				
				veiculos.add(new Moto(fabricante, modelo, pais, valor, passageiros, anoFab, novoDono, potencia));
				
			} else if(opcao == 8) {									//Caminhao ++++++++++++++++++++++++++++++++++++++
				System.out.println("Digite o fabricante do Carro: ");
				fabricante = tcl.next();
				System.out.println("Digite o modelo: ");
				modelo = tcl.next();
				System.out.println("Digite o país de origem: ");
				pais = tcl.next();
				System.out.println("valor : ");
				valor = tcl.nextDouble();
				System.out.println("Quantidade de passageiros: ");
				passageiros = tcl.nextInt();
				System.out.println("Ano de fabricação: ");
				anoFab = tcl.nextInt();
				System.out.println("Nome do proprietario: ");
				novoDono = tcl.next();
				
				veiculos.add(new Caminhao(fabricante, modelo, pais, valor, passageiros, anoFab, novoDono));
				
				
			} else if(opcao == 9) {							//Helicoptero ==========================================
				System.out.println("Digite o fabricante do Carro: ");
				fabricante = tcl.next();
				System.out.println("Digite o modelo: ");
				modelo = tcl.next();
				System.out.println("Rotores: ");
				rotores = tcl.nextInt();
				System.out.println("Digite o país de origem: ");
				pais = tcl.next();
				System.out.println("valor : ");
				valor = tcl.nextDouble();
				System.out.println("Quantidade de passageiros: ");
				passageiros = tcl.nextInt();
				System.out.println("Ano de fabricação: ");
				anoFab = tcl.nextInt();
				System.out.println("Nome da Empresa proprietaria: ");
				novoDono = tcl.next();
				System.out.println("potencia: ");

				
				veiculos.add(new Helicoptero(fabricante, modelo, pais, rotores, valor, passageiros, anoFab, novoDono));
				
				
			} else if(opcao == 10) {					// Aviao =======================================
				System.out.println("Digite o fabricante do Carro: ");
				fabricante = tcl.next();
				System.out.println("Digite o modelo: ");
				modelo = tcl.next();
				System.out.println("Digite o país de origem: ");
				pais = tcl.next();
				System.out.println("valor : ");
				valor = tcl.nextDouble();
				System.out.println("Quantidade de passageiros: ");
				passageiros = tcl.nextInt();
				System.out.println("Ano de fabricação: ");
				anoFab = tcl.nextInt();
				System.out.println("Nome da Empresa proprietaria: ");
				novoDono = tcl.next();
				System.out.println("Velocidade Maxima: ");
				potencia = tcl.nextInt();

				
				veiculos.add(new Aviao(fabricante, modelo, pais, valor, passageiros, anoFab, novoDono, potencia));
				
				
			} else if(opcao == 11) {				// Submarino ****************************************
				System.out.println("Digite o fabricante do Carro: ");
				fabricante = tcl.next();
				System.out.println("Digite o modelo: ");
				modelo = tcl.next();
				System.out.println("Digite o país de origem: ");
				pais = tcl.next();
				System.out.println("valor : ");
				valor = tcl.nextDouble();
				System.out.println("Quantidade de passageiros: ");
				passageiros = tcl.nextInt();
				System.out.println("Ano de fabricação: ");
				anoFab = tcl.nextInt();
				System.out.println("Nome da Empresa proprietaria: ");
				novoDono = tcl.next();
				System.out.println("Profundidade Maxima: ");
				potencia = tcl.nextInt();

				
				veiculos.add(new Submarino(fabricante, modelo, pais, valor, passageiros, anoFab, novoDono, potencia));
				
				
			} else if(opcao == 12) {				// Navio  *******************************************
				System.out.println("Digite o fabricante do Carro: ");
				fabricante = tcl.next();
				System.out.println("Digite o modelo: ");
				modelo = tcl.next();
				System.out.println("Digite o país de origem: ");
				pais = tcl.next();
				System.out.println("valor : ");
				valor = tcl.nextDouble();
				System.out.println("Quantidade de passageiros: ");
				passageiros = tcl.nextInt();
				System.out.println("Ano de fabricação: ");
				anoFab = tcl.nextInt();
				System.out.println("Nome da Empresa proprietaria: ");
				novoDono = tcl.next();
				System.out.println("Nome do Navio: ");
				nome = tcl.next();

				
				veiculos.add(new Navio(fabricante, modelo, pais, valor, passageiros, anoFab, novoDono, nome));	
				
			} else if(opcao == 2){
				for(i = 0; i < veiculos.size(); i++) {
					veiculos.get(i).info();
				}
			} else if(opcao == 3) {
				System.out.println("Digite um valor entre 1 e " + veiculos.size() + " para mostrar os dados do veiculo" );
				i = tcl.nextInt() - 1;
				veiculos.get(i).info();
				veiculos.get(i).posicao();
				
				
			} else if(opcao == 4) {
				System.out.println("Digite um valor entre 1 e" + veiculos.size() + " para atualizar a posição do veiculo" );
				i = tcl.nextInt() - 1;
				tipo = veiculos.get(i).getClass().toString();
				System.out.println(tipo);
				if(tipo.compareTo("class veiculosEDerivacoes.Submarino") == 0 || tipo.compareTo("class veiculosEDerivacoes.Aviao") == 0 || tipo.compareTo("class veiculosEDerivacoes.Helicoptero") == 0) {
					System.out.println("Digite o deslocamento em x");
					x = tcl.nextInt();
					System.out.println("Digite o deslocamento em y");
					y = tcl.nextInt();
					System.out.println("Digite o deslocamento em z");
					z = tcl.nextInt();
					veiculos.get(i).deslocamento(x, y, z);
				} else {
					System.out.println("Digite o deslocamento em x");
					x = tcl.nextInt();
					System.out.println("Digite o deslocamento em y");
					y = tcl.nextInt();
					veiculos.get(i).deslocamento(x, y, 0);
				}
			} else if(opcao == 55) {
				System.out.println("Digite um valor entre 1 e " + veiculos.size() + " para mostrar a posição do veiculo" );
				i = tcl.nextInt() - 1;
				veiculos.get(i).posicao();
			}
			if(opcao != 0)
				menu(99);
			
		} while (opcao > 0);
		
		
	}
	


}
