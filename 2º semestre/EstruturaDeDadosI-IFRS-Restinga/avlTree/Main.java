package avlTree;
import java.io.*;

public class Main {
	public static void menu () {
		System.out.println("########################################################");
		System.out.println("Digite uma opção: ");
		System.out.println("1 - adicione um elemento! ");
		System.out.println("2 - remover um elemento! ");
		System.out.println("3 - mostrar arvore! ");
		System.out.println("4 - mostrar os elementos em PRE-ordem! ");
		System.out.println("5 - mostrar os elementos em ordem! ");
		System.out.println("6 - mostrar os elementos em POS-ordem! ");
		System.out.println("0 - Sair! ");
		System.out.println("########################################################");
	}
	
	public static void main(String[] args) throws Exception {
		int opcao, elemento;
		ArvoreAVL arvore = new ArvoreAVL();
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		
		do {
			menu();
			opcao = Integer.parseInt(in.readLine());
			if(opcao == 1) {
				System.out.println("Digite um número a ser adicionado: ");
				elemento = Integer.parseInt(in.readLine());
				arvore.insere(elemento);
				
			} else if(opcao == 2){
				System.out.println("Digite um número a ser removido: ");
				elemento = Integer.parseInt(in.readLine());
				arvore.remove(elemento);
				
			} else if (opcao == 3) {
				if(arvore.raiz != null) {
					System.out.println(arvore.printArvore()); 
				} else {
					System.out.println("Arvore vazia");
				}
				
			} else if (opcao == 4) {
				arvore.imprime(3);
				
			} else if(opcao == 5) {
				arvore.imprime(1);
				
			} else if(opcao == 6) {
				arvore.imprime(2);
				
			} else if(opcao ==0 ) {
				System.out.println("Até Mais!!1");
			} else {
				System.out.println("Opção inválida!");
			}
		
		} while (opcao != 0);
		
	}
}
