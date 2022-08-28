package listasPilhasFilasV2;
import java.util.Random;
import java.util.Scanner;
import java.io.*;



public class main {
	public static void menu(){
		System.out.println("###################################################################");
		System.out.println("## \t Escolha com qual Estrutura voce deseja interagir \t ##");
		System.out.println("## \t 1 - Listas Duplamentes encadeadas \t\t\t ##");
		System.out.println("## \t 2 - Pilhas \t\t\t\t\t\t ##");
		System.out.println("## \t 3 - Filas \t\t\t\t\t\t ##");
		System.out.println("## \t 0 - SAIR! \t\t\t\t\t\t ##");
		System.out.println("###################################################################");
		System.out.print("Opcao -> ");
	}
	
	public static void menuLista() {
		System.out.println("###################################################################");
		System.out.println("1 - Adicione um Elemento na Lista.");
		System.out.println("2 - Remover um Elemento da Lista.");
		System.out.println("3 - Mostrar a lista.");
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
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int elemento;
		Random generator = new Random();
		int opcao, pos, temp;
		BufferedReader tcl = new BufferedReader(new InputStreamReader(System.in));
		Lista lista = new Lista();
		Pilha pilha = new Pilha();
		Fila fila = new Fila();
	/*	
	//	for(int i =0; i < 100; i++) {			// se adicionar mais um nove dara um erro de stackeroverflow
	//		temp = generator.nextInt(100);
	//		System.out.println("adicionando -> " + temp);
	//		lista.adiciona(temp);
	//	}
		
		for(int i =0; i < 100; i++) {			
			temp = generator.nextInt(100);
			System.out.println("adicionando -> " + temp);
			pilha.adiciona(temp);
		}
		
		for(int i =0; i < 10; i++) {			
			temp = generator.nextInt(10);
			System.out.println("adicionando -> " + temp);
			fila.adiciona(temp);
		}
		

		//System.out.println("primeiro :" + lista.getPrimeiro().getElemento());
		//System.out.println("ultimo: " + lista.getUltimo().getElemento());
		//lista.mostraLista();
		//pilha.mostraPilha();
		fila.mostraFila();
		
		
		for(int i = 0; i< 10; i++) {
			fila.remove();
			fila.mostraFila();
			System.out.println("_____++++++++=======+++++++________");
			if(fila.lista.getPrimeiro() == null) {
				System.out.println("Lista vazia");
			}
		}
		*/
		
		
		do {
			menu();
			opcao = Integer.parseInt(tcl.readLine());
			if(opcao == 1) {
				menuLista();
				opcao = Integer.parseInt(tcl.readLine());
				
				switch(opcao) {
				case 1: System.out.print("Digite um elemento a ser adicionado na lista: ");
						elemento = Integer.parseInt(tcl.readLine());
						lista.adiciona(elemento);
						lista.mostraLista();
						
					break;
				
				case 2: System.out.print("Digite um elemento a ser removido da lista: ");
						elemento = Integer.parseInt(tcl.readLine());
						lista.remove(elemento);
						lista.mostraLista();
					break;
					
					
				case 3: System.out.println(lista);
					break;
				
				
				case 0:System.out.print("Voltando...");
						opcao = -1;
					break;
				
					default:System.out.print("Opção inválida");
					
			} 
				
			} else if (opcao == 2) {
				menuPilha();
				opcao = Integer.parseInt(tcl.readLine());
				
				switch(opcao) {
				case 1: System.out.print("Digite um elemento a ser adicionado a Pilha: ");
						elemento = Integer.parseInt(tcl.readLine());
						pilha.adiciona(elemento);
						pilha.mostraPilha();
					break;
				
				case 2: System.out.print("Removendo um elemento da pilha...");
						pilha.remove();
						pilha.mostraPilha();;
					break;
					
				case 3: if(pilha.vazia()) {
							System.out.print("A pilha está vazia!");
						} else {
							System.out.print("A pilha não está vazia! -> ");
						}
					break;
					
				case 4: pilha.mostraPilha();
					break;
				
				case 0: System.out.println("Voltando...");
						opcao = -1;
					break;
			
					default:System.out.println("Opção inválida");
					
			} 
				
			} else if(opcao == 3) {
				menuFila();
				opcao = Integer.parseInt(tcl.readLine());
				
				switch(opcao) {
					case 1: System.out.print("Digite um elemento a ser adicionado a fila: ");
							elemento = Integer.parseInt(tcl.readLine());
							fila.adiciona(elemento);
							fila.mostraFila();;
						break;
					
					case 2: System.out.print("Removendo um elemento da fila...");
							fila.remove();
							fila.mostraFila();;
						break;
						
					case 3: if(fila.vazia()) {
								System.out.print("A fila está vazia!");
							} else {
								System.out.print("A fila não está vazia! -> ");
							}
						break;
						
					case 4: fila.mostraFila();
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
