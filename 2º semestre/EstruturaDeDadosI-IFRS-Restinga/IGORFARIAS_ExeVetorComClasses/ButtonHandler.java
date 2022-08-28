import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;



public class ButtonHandler implements ActionListener{
	private JButton randomVector, randomOrdenatedVector, insertValue, bubbleShort, selectionShort, insertShort, printVector;
	private JButton eraseInPosition, find, findByBinary, findByBinaryRecursive, howManyEmpty, howManyOccupied, biggestElement;
	private JButton smallerElement, eraseVector, exit;
	public IGORFARIAScVetor vetor;
	
	/*
	 * "-- 1)  Povoar o vetor com n�meros aleatorios. \n" +
	 * "-- 2)  Povoar o vetor com n�meros aleatorios ordenados. \n" +
	 * "-- 3)  Alterar um numero na posição tal. \n" +
	 * "-- 4)  Ordenar o vetor - bubble Short. \n" +
	 * "-- 5)  Ordenar o vetor - Selection Short. \n" +
	 * "-- 6)  Ordenar o vetor - insert Short. \n" +
	 * "-- 7) apagar um valor do vetor - escolhendo qual o elemento que devera ser \"zerado\"\n"
	 * "-- 8) consultar se existe determinado valor no vetor - por forca bruta\n"
	 * "-- 9) consultar se existe determinado valor no vetor - por binario interativa\n"
	 * "-- 10) consultar se existe determinado valor no vetor - por binario recursiva\n"
	 * "-- 11) consultar quantos valores j� ocupam o vetor\n" +
	 * "-- 12) consultar qual o maior valor armazenado no vetor e indicar qual o elemento que cont�m esse valor\n"
	 * "-- 13) consultar qual o menor valor armazenado no vetor e indicar qual o elemento que cont�m esse valor\n"
	 * "-- 14) apresentar uma listagem dos valores armazenados no vetor\n" +
	 * "-- 0) sair do programa \n");
	 */
	
	public ButtonHandler(IGORFARIAScVetor vet, JButton randomVector, JButton randomOrdenatedVector, JButton insertValue,JButton bubbleShort, JButton selectionShort, JButton insertShort,
	JButton eraseInPosition, JButton find, JButton findByBinary, JButton findByBinaryRecursive, JButton howManyEmpty, JButton howManyOccupied, 
	JButton biggestElement, JButton smallerElement, JButton eraseVector, JButton printVector, JButton exit) {
		this.randomVector = randomVector;
		this.randomOrdenatedVector = randomOrdenatedVector;
		this.insertValue = insertValue;
		this.bubbleShort = bubbleShort;
		this.selectionShort = selectionShort; 
		this.insertShort = insertShort;
		this.eraseInPosition = eraseInPosition;
		this.find = find;
		this.findByBinary = findByBinary;
		this.findByBinaryRecursive = findByBinaryRecursive;
		this.howManyEmpty = howManyEmpty;
		this.howManyOccupied = howManyOccupied;
		this.biggestElement = biggestElement;
		this.smallerElement = smallerElement;
		this.eraseVector = eraseVector;
		this.printVector = printVector;
		this.exit = exit;
		
		vetor = vet;

	}
	
	public void actionPerformed(ActionEvent evento) {
			
		  if(evento.getSource() == randomVector) { 
			  JOptionPane.showMessageDialog(null,"Vetor povoado com números aleatorios"); 
			  vetor.randomVector(); 
			  
		  } else if(evento.getSource() == randomOrdenatedVector) {
			  JOptionPane.showMessageDialog(null, "Vetor povoado com números ordenados");
			  vetor.randomOrdenatedVector(); 
			  
		  } else if(evento.getSource() == insertValue) {
			  int pos = Integer.parseInt(JOptionPane.showInputDialog("Digite um a posição do vetor em que você deseja alterar?"));
			  int value = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor que você deseja colocar: "));
			  vetor.insertValue(pos, value); 
			  
		  } else if(evento.getSource() == bubbleShort) { 
			  vetor.bubbleShort();
			  JOptionPane.showMessageDialog(null, "Vetor ordenado!(bubble Short)");
			  
		  } else if(evento.getSource() == selectionShort) { 
			  vetor.selectionShort();
			  JOptionPane.showMessageDialog(null, "Vetor ordenado!(selection Short)");
			  
		  }  else if(evento.getSource() == insertShort) { 
			  vetor.insertShort();
			  JOptionPane.showMessageDialog(null, "Vetor ordenado! (insert Short)");
			  
		  } else if(evento.getSource() == eraseInPosition) { 
			  int pos = Integer.parseInt(JOptionPane.showInputDialog("Digite um a posição do vetor em que você apagar o valor armazenado? "));
			  vetor.eraseInPosition(pos);
			  JOptionPane.showMessageDialog(null, "Vetor ordenado!");
			  
		  } else if(evento.getSource() == find) {
			  int value = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor que você deseja encontrar no vetor: "));
			  vetor.find(value);
		  
		  }  else if(evento.getSource() == findByBinary) {
			  int value = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor que você deseja encontrar no vetor: "));
			  int pos = vetor.findByBinary(value);
			  if(pos == -1) {
				  JOptionPane.showMessageDialog(null, "O valor não foi encontrado");
			  } else {
				  JOptionPane.showMessageDialog(null, "O valor foi encontrado na posição " + (pos +1));
			  } 
		  
		  }  else if(evento.getSource() == findByBinaryRecursive) {
			  int value = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor que você deseja encontrar no vetor: "));
			  int pos =  vetor.findByBinaryRecursive(value);
			  if(pos == -1) {
				  JOptionPane.showMessageDialog(null, "O valor não foi encontrado");
			  } else {
				  JOptionPane.showMessageDialog(null, "O valor foi encontrado na posição " + (pos +1));
			  } 
			  
		  
		  } else if(evento.getSource() == howManyEmpty) {
			  int quant =  vetor.howManyEmpty();
			  JOptionPane.showMessageDialog(null, "O vetor tem " + quant + " posições vazias");
		 
			  
		  } else if(evento.getSource() == howManyOccupied) {
			  int quant = vetor.howManyOccupied();
			  JOptionPane.showMessageDialog(null, "O vetor tem " + quant + " posições ocupadas");
			  
			  
		  } else if(evento.getSource() == biggestElement) {
			  int biggest = vetor.biggestElement();
			  JOptionPane.showMessageDialog(null, "O maior elemento no vetor é " + biggest );
			  
			  
		  } else if(evento.getSource() == smallerElement) {
			  int smaller = vetor.smallerElement();
			  JOptionPane.showMessageDialog(null, "O menor elemento no vetor é " + smaller );
			  
			  
		  }  else if(evento.getSource() == eraseVector) {
			  vetor.eraseVector();
			  JOptionPane.showMessageDialog(null, "O vetor foi apagado!!!");
			  
			  
		  } else if(evento.getSource() == printVector) {
			  vetor.printVector(); 
			  System.out.println(vetor.vectorLength());
		 
			  
		  } else if(evento.getSource() == exit) {
			  JOptionPane.showMessageDialog(null, "Até Mais!!!");
			  System.exit(0);
		  }
		 
	}
}
