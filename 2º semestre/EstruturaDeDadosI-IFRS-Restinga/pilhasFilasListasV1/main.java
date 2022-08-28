package listasPilhasFilasV2;
import java.util.Scanner;



public class main {
	public static void menu(){
		System.out.println("###################################################################");
		System.out.println("## \t Escolha com qual Estrutura voce deseja interagir \t ##");
		System.out.println("## \t 1 - Listas Duplamentes encadeadas \t\t\t ##");
		System.out.println("## \t 2 - Pilhas \t\t\t\t\t\t ##");
		System.out.println("## \t 3 - Filas \t\t\t\t\t\t ##");
		System.out.println("###################################################################");
		System.out.print("Opcao -> ");
	}
	
	public static void menuLista() {
		System.out.println("###################################################################");
		System.out.println("1 - Adicione um Elemento no final de uma Lista.");
		System.out.println("2 - Adicione um Elemento no começo de uma Lista.");
		System.out.println("3 - Adicione um Elemento em determinada posição do Vetor.");
		System.out.println("4 - Remover um Elemento no inicio da Lista.");
		System.out.println("5 - Remover um Elemento no final da Lista.");
		System.out.println("6 - Remover um Elemento em determinada posição");
		System.out.println("7 - mostrar elementos");
		System.out.println("0 - Voltar ao menu anterior...");
		System.out.println("###################################################################");
		System.out.print("Opcao -> ");
	}
	
	public static void menuPilha() {
		System.out.println("###################################################################");
		System.out.println("1 - Adicione um Elemento a pilha.");
		System.out.println("2 - Remover um Elemento da Pilha.");
		System.out.println("3 - Verifica se a pilha está vazia.");
		System.out.println("4 - mostrar elementos");
		System.out.println("0 - Voltar ao menu anterior...");
		System.out.println("###################################################################");
		System.out.print("Opcao -> ");

	} 
	
	public static void menuFila() {
		System.out.println("###################################################################");
		System.out.println("1 - Adicione um Elemento a Fila.");
		System.out.println("2 - Remover um Elemento da Fila.");
		System.out.println("3 - Verifica se a Fila está vazia.");
		System.out.println("4 - mostrar elementos");
		System.out.println("0 - Voltar ao menu anterior...");
		System.out.println("###################################################################");
		System.out.print("Opcao -> ");
	}
	
	public static void main(String[] args) {
		Object elemento;
		int opcao, pos;
		Scanner tcl = new Scanner(System.in);
		Lista lista = new Lista();
		Pilha pilha = new Pilha();
		Fila fila = new Fila();
		
		
		lista.adiciona(1);
		lista.adiciona(2);
		lista.adiciona(3);
		lista.adiciona(4);
		lista.adiciona(5);
		/*
		do {
			menu();
			opcao = tcl.nextInt();
			if(opcao == 1) {
				menuLista();
				opcao = tcl.nextInt();
				
				switch(opcao) {
				case 1: System.out.print("Digite um elemento a ser adicionado no final da lista: ");
						elemento = tcl.next();
						lista.adiciona(elemento);
						System.out.println(lista);
						
					break;
				
				case 2: System.out.print("Digite um elemento a ser adicionado no comeco da lista: ");
						elemento = tcl.next();
						lista.adicionaNoComeco(elemento);;
						System.out.println(lista);
					break;
					
				case 3: System.out.print("Digite um elemento a ser adicionado na lista: ");
						elemento = tcl.next();
						System.out.print("\n Digite a posicao que deseja inserir esse elemento(de 0 a " + (lista.tamanho() - 1) + "): ");
						pos = tcl.nextInt();
						lista.adiciona(pos, elemento);
						System.out.println(lista);
					break;
					
				case 4: System.out.print("Removendo elemento no comeco da lista...");
						lista.removeDoComeco();
						System.out.println("Elemento removido! - " + lista);
					break;
				
				case 5: System.out.print("Removendo elemento no final da lista...");
						lista.removeDoFim();
						System.out.println("Elemento removido! - " + lista);
					break;
				
				case 6: System.out.print("Digite uma posição para remover o elemento(de 0 a "+ (lista.tamanho() - 1) + "): ");
						pos = tcl.nextInt();
						lista.remove(pos);
						System.out.println("Elemento removido! - " + lista);
					break;
					
				case 7: System.out.println(lista);
					break;
				
				
				case 0:System.out.print("Voltando...");
						opcao = -1;
					break;
				
					default:System.out.print("Opção inválida");
					
			} 
				
			} else if (opcao == 2) {
				menuPilha();
				opcao = tcl.nextInt();
				
				switch(opcao) {
				case 1: System.out.print("Digite um elemento a ser adicionado a Pilha: ");
						elemento = tcl.next();
						pilha.adiciona(elemento);
						System.out.println(pilha);
					break;
				
				case 2: System.out.print("Removendo um elemento da pilha...");
						pilha.remove();
						System.out.println(pilha);
					break;
					
				case 3: if(pilha.vazia()) {
							System.out.print("A pilha está vazia!");
						} else {
							System.out.print("A pilha não está vazia! -> " + pilha);
						}
					break;
					
				case 4: System.out.println(pilha);
				break;
				
				case 0: System.out.println("Voltando...");
						opcao = -1;
					break;
			
					default:System.out.println("Opção inválida");
					
			} 
				
			} else if(opcao == 3) {
				menuFila();
				opcao = tcl.nextInt();
				
				switch(opcao) {
					case 1: System.out.print("Digite um elemento a ser adicionado a fila: ");
							elemento = tcl.next();
							fila.adiciona(elemento);
							System.out.println(fila);
						break;
					
					case 2: System.out.print("Removendo um elemento da fila...");
							fila.remove();
							System.out.println(fila);
						break;
						
					case 3: if(fila.vazia()) {
								System.out.print("A fila está vazia!");
							} else {
								System.out.print("A fila não está vazia! -> " + fila);
							}
						break;
						
					case 4: System.out.println(fila);
					break;
					
					case 0:System.out.println("Voltando...");
							opcao = -1;
						break;
				
						default:System.out.println("Opção inválida");
						
				} 
				
			} else if(opcao == 0){
				System.out.println("até mais!!");
			} else {
				System.out.println("Opcao invalida");
			}
		} while (opcao != 0);

		*/
		
		
		
		
/* //testes sem interatividade
	//fila  - FIFO - Constante
		fila.adiciona("IGOR");
		System.out.println(fila);
			
		fila.adiciona("vitinho");
		System.out.println(fila);
				
		fila.adiciona("rabanada");
		System.out.println(fila);
				
		fila.adiciona("joao");
		System.out.println(fila);
				
		fila.adiciona("polenta");
		System.out.println(fila);
				
		fila.remove();
		System.out.println(fila);
		
		fila.remove();
		System.out.println(fila);
				
		fila.remove();
		System.out.println(fila);
				
		fila.remove();
		System.out.println(fila);
				
		fila.remove();
		System.out.println(fila);
		
		
		
//pilhas - LIFO - Constante
		pilha.adiciona("IGOR");
		System.out.println(pilha);
		
		pilha.adiciona("LEO");
		System.out.println(pilha);
		
		pilha.adiciona("rabanada");
		System.out.println(pilha);
		
		pilha.adiciona("joao");
		System.out.println(pilha);
		
		pilha.adiciona("polenta");
		System.out.println(pilha);
		
		pilha.remove();
		System.out.println(pilha);
		
		pilha.remove();
		System.out.println(pilha);
		
		pilha.remove();
		System.out.println(pilha);
		
		pilha.remove();
		System.out.println(pilha);
		
		pilha.remove();
		System.out.println(pilha);
		
		
// listas encadeadas
		System.out.println(lista);
		lista.adicionaNoComeco("Rogerio");
		System.out.println(lista);
		lista.adicionaNoComeco("Paulo");
		System.out.println(lista);
		lista.adicionaNoComeco("Corvino");
		System.out.println(lista);
		
		lista.adiciona("Dionisio");
		System.out.println(lista);
		
		lista.adiciona(2, "Rafael");
		System.out.println(lista);
		
		Object x = lista.pega(2);
		System.out.println(x);
		
		System.out.println("tamanho atual da lista Duplamente Ligada: " + lista.tamanho());
		
		lista.removeDoFim();
		System.out.println(lista);
		
		System.out.println("tamanho atual da lista Duplamente Ligada: " + lista.tamanho());
		
		lista.removeDoComeco();
		System.out.println(lista);
		System.out.println(lista.tamanho());
		
		lista.remove(2);
		System.out.println(lista);
		
		System.out.println("tamanho atual da lista Duplamente Ligada: " + lista.tamanho());
		
		System.out.println(lista.contem("Pantera"));
		System.out.println(lista.contem("Capitao"));
		System.out.println(lista.contem("Stricken"));
		System.out.println(lista.contem("Rafael"));
		System.out.println(lista.contem("Casemiro"));
		
*/	
		
		
		
	}
}
