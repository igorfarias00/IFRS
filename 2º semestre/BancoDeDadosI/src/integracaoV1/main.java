package integracaoV1;
/* talvez fosse mais interessante criar uma classe de conexao com o banco em separado da classe professor
 * 
 */
import java.io.*;
import java.util.ArrayList;

public class main {
	public static void menu() {
		System.out.println("##################################");
		System.out.println("1 - Criar um novo professor ");
		System.out.println("2 - inserir Professor no banco ");
		System.out.println("3 - atualizar informação de um Professor");
		System.out.println("4 - buscar um Professor pela matricula");
		System.out.println("5 - excluir um Professor ");
		System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
	}
	
	public static void main(String[] args) throws Exception {
		int opcao, i, matricula;
		boolean profEncontrado = false;
		String nome, coord;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// para fazer a inserção nas chaves estrangeiras é necessario que existam os campos na tabela 
		Professor p1 = new Professor();
		Professor p2 = new Professor();
		
		ArrayList<Professor> professores = new ArrayList<>();
		
		p1.id = 1;
		p1.nome = "Sebastiao";
		p1.matricula = 12351;
		p1.numero = 21341;
		p1.complemento = "Rua da graça";
		p1.salario = 4330.34;
		p1.nivel_formacao = "POS DOC";
		p1.Telefone_id = 33;				// FK
		p1.Endereco_id = 12;				// FK
		p1.coordenador = false;
		
		p1.inserir();
		
	//	p1.consultar(p1.matricula);

		
		p2.nome = "Melo";
		p2.numero = 21351;
		p2.complemento = "Rua da desgraça";
		p2.salario = 4330.34;
		p2.nivel_formacao = "pedreiro";
		p2.Telefone_id = 33;				// FK
		p2.Endereco_id = 12;				// FK
		p2.coordenador = true;
		
		
		p1.id = 16;
		p1.atualizar();
		
		p1.excluir();
		
		p1.inserir();
		                
		//p2.inserir();
		
		//p1.consultar(p1.matricula);
		System.out.println("*************");
		//p2.consultar(p2.matricula);
		
		professores.add(p2);
		professores.add(p1);
		
		do {
			menu();
			opcao = Integer.parseInt(in.readLine());
			
			if(opcao == 1) {
				Professor novoProf = new Professor();
				System.out.println("Digite o nome do professor: ");
				novoProf.nome = in.readLine();
				
				System.out.println("Qual o numero de matricula desse professor? ");
				novoProf.matricula = Integer.parseInt(in.readLine());
				
				System.out.println("Digite o id correspondente da tabela de enderecos desse professor: ");
				novoProf.Endereco_id = Integer.parseInt(in.readLine());
				
				System.out.println("Informe o complemento do endereco: ");
				novoProf.complemento = in.readLine();
				
				System.out.println("Informe o salario do professor: ");
				novoProf.salario = Double.parseDouble(in.readLine());
				
				System.out.println("Qual a formação desse professor? ");
				novoProf.nivel_formacao = in.readLine();
				
				System.out.println("Digite o id correspondente da tabela de telefones desse professor: ");
				novoProf.Telefone_id = Integer.parseInt(in.readLine());
				
				System.out.println("Esse professor é um coordenador?");
				coord = in.readLine();
				if(coord.compareToIgnoreCase("sim") == 0) {
					novoProf.coordenador = true ;
				} else if(coord.compareToIgnoreCase("nao") == 0) {
					novoProf.coordenador = false ;
				}
				
				professores.add(novoProf);
				
			} else if(opcao == 2) {
				System.out.println("Digite o nome do professor: ");
				nome = in.readLine();
				
				for(i =0; i < professores.size(); i++) {
					if(professores.get(i).nome.compareToIgnoreCase(nome) == 0) {
						professores.get(i).inserir();
						profEncontrado = true;
						System.out.println("Professor inserido na tabela com sucesso!");
					}
				}
				
				if(profEncontrado == false) {
					System.out.println("Professor nao cadastrado!");
				}
				
				profEncontrado = false;
				
			} else if(opcao == 3) {
				System.out.println("Digite o nome do professor: ");
				nome = in.readLine();
				
				for(i =0; i < professores.size(); i++) {
					if(professores.get(i).nome.compareToIgnoreCase(nome) == 0) {
						System.out.println("Digite o nome do professor: ");
						professores.get(i).nome = in.readLine();
						
						System.out.println("Qual o numero de matricula desse professor? ");
						professores.get(i).matricula = Integer.parseInt(in.readLine());
						
						System.out.println("Digite o id correspondente da tabela de enderecos desse professor: ");
						professores.get(i).Endereco_id = Integer.parseInt(in.readLine());
						
						System.out.println("Informe o complemento do endereco: ");
						professores.get(i).complemento = in.readLine();
						
						System.out.println("Informe o salario do professor: ");
						professores.get(i).salario = Double.parseDouble(in.readLine());
						
						System.out.println("Qual a formação desse professor? ");
						professores.get(i).nivel_formacao = in.readLine();
						
						System.out.println("Digite o id correspondente da tabela de telefones desse professor: ");
						professores.get(i).Telefone_id = Integer.parseInt(in.readLine());
						
						System.out.println("Esse professor é um coordenador?");
						coord = in.readLine();
						if(coord.compareToIgnoreCase("sim") == 0) {
							professores.get(i).coordenador = true ;
						} else if(coord.compareToIgnoreCase("nao") == 0) {
							professores.get(i).coordenador = false ;
						}
						
						
						
						professores.get(i).atualizar();
						profEncontrado = true;
						System.out.println("Professor atualizado na tabela com sucesso!");
					}
				}
				
				if(profEncontrado == false) {
					System.out.println("Professor nao cadastrado!");
				}
				
				profEncontrado = false;
				
			} else if(opcao == 4) {
				System.out.println("Digite a matricula do professor: ");
				matricula = Integer.parseInt(in.readLine());
				
				professores.get(0).consultar(matricula);
				
	
			} else if(opcao == 5) {
				System.out.println("Digite o nome do professor: ");
				nome = in.readLine();
				
				for(i =0; i < professores.size(); i++) {
					if(professores.get(i).nome.compareToIgnoreCase(nome) == 0) {
						profEncontrado = true;
						professores.get(i).excluir();
					}
				}
				
				if(profEncontrado == false) {
					System.out.println("Professor não cadastrado");
				}
				
				profEncontrado = false;
				
			} else if(opcao == 0) {
				System.out.println("Ate mais! :3");
			} else {
				System.out.println("OPCAO INVALIDA!!!");
			}
			
		} while (opcao != 0);
	}
}
