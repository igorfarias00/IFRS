package grafo;

import java.io.*;
import java.util.ArrayList;

public class main {
	public static void menu() {
		System.out.println("##########################################");
		System.out.println("1 - Cadastrar uma cidade");
		System.out.println("2 - Cadastrar uma conexão");
		System.out.println("3 - listar cidades ");
		System.out.println("4 - listar conexoes ");
		System.out.println("5 - listar cidades vizinhas");
		System.out.println("##########################################");
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int opcao, distancia, i, j;
		boolean cadastrado = false;
		String nomeCidade;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Vertice> vertices = new ArrayList<Vertice>();		
	
		Grafo grafinho = new Grafo();
		
		// criando cidades para testes


		
		//cadastrando cidades 
		grafinho.cadastra_cidade("columbia");
		grafinho.cadastra_cidade("porto alegre");
		grafinho.cadastra_cidade("sao paulo");
		grafinho.cadastra_conexao(grafinho.cidades.get(0), grafinho.cidades.get(1), 435069);

		//grafinho.info_cidades();
		
		System.out.println("()()()()()()()()()()()()()()()()()()");
		
		//grafinho.info_cidades();
		
		do {
			menu();
			opcao = Integer.parseInt(in.readLine());
			if(opcao == 1) {
				System.out.println("Digite o nome da cidade que deseja cadastrar: ");
				grafinho.cadastra_cidade(in.readLine());
				
			} else if(opcao == 2){
				System.out.println("digite o nome da cidade da conexao: ");
				nomeCidade = in.readLine().toLowerCase();
				
				for (i = 0; i< grafinho.cidades.size(); i++) {
					if(nomeCidade.compareTo( grafinho.cidades.get(i).nomeCidade) == 0) {
						if(cadastrado) {
							break;
						}
						System.out.println("Digite o nome da segunda cidade: ");
						nomeCidade = in.readLine().toLowerCase();
						for(j = 0; j < grafinho.cidades.size(); j++) {
							if(nomeCidade.compareTo( grafinho.cidades.get(j).nomeCidade) == 0) {
								System.out.println("Digite a distancia entre essas cidades: ");
								distancia = Integer.parseInt(in.readLine());
								System.out.println("Cadastrando conexao....");
								
								grafinho.cadastra_conexao(grafinho.cidades.get(i), grafinho.cidades.get(j), distancia);
								cadastrado = true;
								System.out.println("Cadastrado com sucesso!");
								break; 
							}
						}
						if(j == grafinho.cidades.size()) {
							System.out.println("Cidade 2 não encontrada");
						} 
						
					}
				}
				if(i == grafinho.cidades.size()+1) {
					System.out.println("Cidade 1 não encontrada");
				}
				
				cadastrado = false;
				
			} else if(opcao == 3){
				grafinho.info_cidades();
				
			
			} else if(opcao == 4){
			
				System.out.println("Digite a cidade que deseja pesquisar");
				nomeCidade = in.readLine().toLowerCase();
				for(i = 0; i < grafinho.cidades.size(); i++) {
					if(nomeCidade.compareTo( grafinho.cidades.get(i).nomeCidade) == 0) {
						System.out.println("Cidade encontrada....");
						grafinho.cidades.get(i).info_conexoes();
						
					}
				}
				
			} else if(opcao == 5){
			
				System.out.println("Digite a cidade que deseja pesquisar");
				nomeCidade = in.readLine().toLowerCase();
				for(i = 0; i < grafinho.cidades.size(); i++) {
					if(nomeCidade.compareTo( grafinho.cidades.get(i).nomeCidade) == 0) {
						System.out.println("Cidade encontrada....");
						grafinho.cidades.get(i).info_vizinhos();
						
					}
				}
				
			}else if(opcao == 0){
				System.out.println("Ate mais!");
				
			} else {
				System.out.println("Opcao invalida!!!");
				
			}
			
			
			
		} while(opcao != 0);
		
	}
}
