import java.util.Scanner;
import javax.swing.*;

public class IGORFARIAS_ExeVetorComClasses {

	public static String printMenu() {
		String menu;
		menu =  "-- 1)  Povoar o vetor com n�meros aleatorios. \n" +
				"-- 2)  Povoar o vetor com n�meros aleatorios ordenados. \n" +
				"-- 3)  Alterar um numero na posição tal. \n" +
				"-- 4)  Ordenar o vetor - bubble Short. \n" +
				"-- 5)  Ordenar o vetor - Selection Short. \n" +
				"-- 6)  Ordenar o vetor - insert Short. \n" +
				"-- 7) apagar um valor do vetor - escolhendo qual o elemento que devera ser \"zerado\"\n" +
				"-- 8) consultar se existe determinado valor no vetor - por forca bruta\n" +
				"-- 9) consultar se existe determinado valor no vetor - por binario interativa\n" +
				"-- 10) consultar se existe determinado valor no vetor - por binario recursiva\n" +
				"-- 11) consultar quantos valores j� ocupam o vetor\n" +
				"-- 12) consultar qual o maior valor armazenado no vetor e indicar qual o elemento que cont�m esse valor\n" +
				"-- 13) consultar qual o menor valor armazenado no vetor e indicar qual o elemento que cont�m esse valor\n" +
				"-- 14) apresentar uma listagem dos valores armazenados no vetor\n" +
				"-- 0) sair do programa \n";
		
		System.out.printf(
				"-- 1)  Povoar o vetor com n�meros aleatorios. \n" +
				"-- 2)  Povoar o vetor com n�meros aleatorios ordenados. \n" +
				"-- 3)  Alterar um numero na posição tal. \n" +
				"-- 4)  Ordenar o vetor - bubble Short. \n" +
				"-- 5)  Ordenar o vetor - Selection Short. \n" +
				"-- 6)  Ordenar o vetor - insert Short. \n" +
				"-- 7) apagar um valor do vetor - escolhendo qual o elemento que devera ser \"zerado\"\n" +
				"-- 8) consultar se existe determinado valor no vetor - por forca bruta\n" +
				"-- 9) consultar se existe determinado valor no vetor - por binario interativa\n" +
				"-- 10) consultar se existe determinado valor no vetor - por binario recursiva\n" +
				"-- 11) consultar quantos valores j� ocupam o vetor\n" +
				"-- 12) consultar qual o maior valor armazenado no vetor e indicar qual o elemento que cont�m esse valor\n" +
				"-- 13) consultar qual o menor valor armazenado no vetor e indicar qual o elemento que cont�m esse valor\n" +
				"-- 14) apresentar uma listagem dos valores armazenados no vetor\n" +
				"-- 0) sair do programa \n");
		return menu;
	}

	public static void main(String[] args) {
		Scanner tcl = new Scanner(System.in);
		int vetSize, opcMenu, pos, value;

		vetSize = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor que você quer criar: "));
		
		while(vetSize <= 0){
			JOptionPane.showInputDialog("O valor que você informou é invalido, tente novamente digitando um valor maior que zero");
			vetSize = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor que voc� quer criar: "));
		}
	
		IGORFARIAScVetor vector = new IGORFARIAScVetor(vetSize);
		
		Button meuPainel = new Button(vector);
		
		meuPainel.setSize(350, 600);
		meuPainel.setVisible(true);
		
				
		while(vetSize <= 0){
			JOptionPane.showInputDialog("O valor que você informou é invalido, tente novamente digitando um valor maior que zero");
			vetSize = Integer.parseInt(JOptionPane.showInputDialog("Digite o tamanho do vetor que voc� quer criar: "));
		}
	
		
		

		
/*		menu criado com janelas pop-up. alterado para um menu com botões

		do {
			
			opcMenu = Integer.parseInt(JOptionPane.showInputDialog(printMenu() + "\n Digite a sua opção"));  					// faz uma nova leitura da op��o do menu
			switch(opcMenu) {
				
				case 1:	vet.randomVector();
						opcMenu = -1;								// reseta a flag, para o programa se manter na sele��o do menu
						break;
				
				case 2:	vet.randomOrdenatedVector();
						opcMenu = -1;	
						break;
				
				case 3:	pos = Integer.parseInt(JOptionPane.showInputDialog("Digite um a posi��o do vetor em que voc� deseja alterar?"));
						value = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor que voc� deseja colocar: "));
						vet.insertValue(pos, value);
						opcMenu = -1;								// reseta a flag, para o programa se manter na sele��o do menu
						break;
						

						
				case 4:	vet.bubbleShort();
						opcMenu = -1;								// reseta a flag para o programa se manter na sele��o do menu
						break;
				
				case 5:	vet.selectionShort();
						opcMenu = -1;								// reseta a flag para o programa se manter na sele��o do menu
						break;
		
				case 6:	vet.insertShort();
						opcMenu = -1;								// reseta a flag para o programa se manter na sele��o do menu
						break;
		
				
				case 7: pos = Integer.parseInt(JOptionPane.showInputDialog("Digite um a posição do vetor em que você apagar o valor armazenado? "));
						vet.eraseInPositon(pos);
						opcMenu = -1;								// reseta a flag para o programa se manter na sele��o do menu
						break;
			
				case 8: value = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor que você deseja encontrar no vetor: "));
						vet.find(value);
						opcMenu = -1;								// reseta a flag para o programa se manter na sele��o do menu
						break;
						
				case 9: value = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor que você deseja encontrar no vetor(com interatividade): "));
						if(vet.findByBinaryInteractive(value) != -1) {
							JOptionPane.showMessageDialog(null, "O valor foi encontrado na posição "+ (vet.findByBinaryInteractive(value) + 1));
						} else {
							JOptionPane.showMessageDialog(null, "O valor não foi encontrado no vetor.");
						}
						opcMenu = -1;								// reseta a flag para o programa se manter na sele��o do menu
						break;
				
				case 10: value = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor que você deseja encontrar no vetor(usando recursividade): "));
						if(vet.findByBinaryRecursive(value) != -1) {
							JOptionPane.showMessageDialog(null, "O valor foi encontrado na posição "+ (vet.findByBinaryRecursive(value) + 1));
						} else {
							JOptionPane.showMessageDialog(null, "O valor não foi encontrado no vetor.");
						}
						
						opcMenu = -1;								// reseta a flag para o programa se manter na sele��o do menu
						break;

				case 11:	vet.howManyEmpty();
						opcMenu = -1;								// reseta a flag para o programa se manter na sele��o do menu
						break;	

				case 12: JOptionPane.showMessageDialog(null, "O maior elemento é " + vet.biggestElement());
						opcMenu = -1;								// reseta a flag para o programa se manter na sele��o do menu
						break;

				case 13: JOptionPane.showMessageDialog(null, "O menor elemento é " + vet.smallerElement());
						opcMenu = -1;								// reseta a flag para o programa se manter na sele��o do menu
						break;			

				case 14: 
						vet.printVector();
						opcMenu = -1;								// reseta a flag para o programa se manter na sele��o do menu
						break;

				case 0:	System.out.println("Até MAIS! ");
						JOptionPane.showMessageDialog(null, "Até MAIS!!!");
						break;

				default: System.out.println("Opção invalida - digite a opção desejada\n");  // caso nenhuma op��o valida seja selecionada
						 JOptionPane.showMessageDialog(null, "Opção invalida - digite a opção desejada");

			}
		}while (opcMenu < 0 || opcMenu > 8);
		
		
		
*/		
	}
}