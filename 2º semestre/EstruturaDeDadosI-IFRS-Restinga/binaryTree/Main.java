package binaryTree;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		ArvoreBinaria dicionario = new ArvoreBinaria();
		BufferedReader in = new BufferedReader( new InputStreamReader(System.in));
		
		int chave = Integer.parseInt(in.readLine());
		while(chave > 0) {
			MeuItem item = new MeuItem(chave);
			dicionario.insere(item);
			chave = Integer.parseInt(in.readLine());
		}
		
		dicionario.imprime();
		System.out.println("Digite um elemento a ser removido");
		MeuItem item  = new MeuItem(Integer.parseInt(in.readLine()));
		dicionario.remove(item);
		dicionario.imprime();
		
	}
}
