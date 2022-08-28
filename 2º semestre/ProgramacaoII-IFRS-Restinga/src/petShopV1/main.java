package petShopV1;
import java.util.ArrayList;
import java.io.*;

public class main {
	
	public static void menu() {
		System.out.println("##############¨¨¨¨¨¨¨¨####################");
		System.out.println("Digite uma opção: ");
		System.out.println("1 - Cadastrar nova Pessoa. ");
		System.out.println("2 - Cadastrar novo Tutor para um pet. ");
		System.out.println("3 - Cadastrar novo Pet. ");
		System.out.println("4 - Adicionar telefone no cadastro de um tutor. ");
		System.out.println("5 - Mostrar os tutores de determinado pet");
		System.out.println("6 - Mostrar os pets de determinado Tutor");
		System.out.println("7 - Pesquisar os dados de contado dos tutores de um Pet");
		System.out.println("0 - Sair!");
		System.out.println("##############¨¨¨¨¨¨¨¨####################");
	}
	
	public static void main(String[] args) throws IOException {
		int opcao, i, telefone, cpf, idade;
		String str = "", nome, endereco, email, raca, especie ;
		ArrayList<Pessoa> pessoas = new ArrayList();
		ArrayList<Pet> pets = new ArrayList();
		ArrayList<Tutor> tutores = new ArrayList();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		tutores.add(new Tutor("Joao", 9999,"Rua das bromelias", "gavetao@comodoa.com.br", 696969));
		tutores.add(new Tutor("romario", 5648, "Rua das bromelias", "gavetao@comodoa.com.br", 65849));
		tutores.add(new Tutor("josefina", 8888,"Rua ornamentada", "liso@kilo.com.br", 68971));
		
		tutores.get(0).addTelefones(84526);
		tutores.get(0).addTelefones(51236);
		
		pets.add(new Pet("Bidu","Monica", "azul", 60));
		
		pets.get(0).addTutor(tutores.get(0));
		pets.get(0).addTutor(tutores.get(1));
		pets.get(0).addTutor(tutores.get(2));
		
		tutores.get(0).addPet(pets.get(0));
		tutores.get(1).addPet(pets.get(0));
		tutores.get(2).addPet(pets.get(0));
		
		//tutor.set
		do {
			menu();
			opcao = Integer.parseInt(in.readLine());
			if(opcao == 1) {
				System.out.println("Digite o nome da pessoa: ");
				nome = in.readLine();
				System.out.println("Digite o cpf do cidadao: ");
				cpf = Integer.parseInt(in.readLine());
				System.out.println("Digite o endecero onde ele reside: ");
				endereco = in.readLine();
				System.out.println("Digite o email: ");
				email = in.readLine();
				System.out.println("Digite o numero de telefone: ");
				telefone = Integer.parseInt(in.readLine());

				pessoas.add(new Pessoa(nome, cpf, endereco, email, telefone));
			
			} else if(opcao == 2) {
				System.out.println("Digite o nome do novo tutor: ");
				nome = in.readLine();
				System.out.println("Digite o cpf do cidadao: ");
				cpf = Integer.parseInt(in.readLine());
				System.out.println("Digite o endecero onde ele reside: ");
				endereco = in.readLine();
				System.out.println("Digite o email: ");
				email = in.readLine();
				System.out.println("Digite o numero de telefone: ");
				telefone = Integer.parseInt(in.readLine());
				
				tutores.add(new Tutor(nome, cpf, endereco, email, telefone));
			
			} else if(opcao == 3) {
				System.out.println("Digite o nome do novo Pet: ");
				nome = in.readLine();
				System.out.println("Digite a especie: ");
				especie =in.readLine();
				System.out.println("Digite a raca: ");
				raca = in.readLine();
				System.out.println("Digite a idade do animal: ");
				idade = Integer.parseInt(in.readLine());

				pets.add(new Pet(nome, especie, raca, idade));
			
			} else if(opcao == 4) {
				System.out.println("Digite o nome do tutor: ");
				str = in.readLine();
	
				for(i = 0; i < tutores.size(); i++) {
					if(tutores.get(i).getNome_completo().compareToIgnoreCase(str)== 0) {
						break;
					}
				}
				
				if(i == tutores.size()) {
					System.out.println("Tutor não encontrado");
				} else {
					System.out.println("Digite o novo numero: ");
					telefone = Integer.parseInt(in.readLine());
					tutores.get(i).addTelefones(telefone);
				}
			
			}else if(opcao == 5) {
				System.out.println("Digite o nome do pet que voce deseja pesquisar: ");
				str = in.readLine();
	
				for(i =0; i < pets.size(); i++) {
					if(pets.get(i).getNome().compareToIgnoreCase(str)== 0) {
						break;
					}
				}
				
				if(i == pets.size()) {
					System.out.println("Pet não encontrado");
				} else {
					System.out.println(pets.get(i).info_tutores());
				}
				
			} else if (opcao == 6) {
				System.out.println("Digite o nome do tutor: ");
				str = in.readLine();
	
				for(i = 0; i < tutores.size(); i++) {
					if(tutores.get(i).getNome_completo().compareToIgnoreCase(str)== 0) {
						break;
					}
				}
				
				if(i == tutores.size()) {
					System.out.println("Tutor não encontrado");
				} else {
					System.out.println(tutores.get(i).info_pets());
				}
				
				
			} else if (opcao == 7) {
				System.out.println("Digite o nome do pet: ");
				str = in.readLine();
	
				for(i = 0; i < tutores.size(); i++) {
					if(pets.get(i).getNome().compareToIgnoreCase(str)== 0) {
						break;
					}
				}
				
				if(i == pets.size()) {
					System.out.println("Tutor não encontrado");
				} else {
					for(int j = 0; j < pets.get(i).quantTutores(); j++) {
						System.out.println("Tutor: " + pets.get(i).getTutor(j).getNome_completo());
						System.out.println(pets.get(i).getTutor(j).info_contato());
					}
				}
				
				
			}else if (opcao == 0) {
				System.out.println("Sainda... até mais!");
			} else {
				System.out.println("Opcao invalida!!!");
			}
			
		} while (opcao != 0);

		
		
		
		
	}
}
