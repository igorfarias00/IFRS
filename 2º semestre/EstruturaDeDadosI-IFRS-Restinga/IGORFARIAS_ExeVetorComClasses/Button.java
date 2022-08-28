import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class Button extends JFrame{
	private JButton randomVector = new JButton("criar vetor randomico.");
	private JButton randomOrdenatedVector = new JButton("criar vetor randomico ordenado");
	private JButton insertValue = new JButton("Inserir valor em determinada posição");
	private JButton bubbleShort = new JButton("Ordenar vetor - com Bubble Short");
	private JButton selectionShort = new JButton("Ordenar vetor - com Selection Short");
	private JButton insertShort = new JButton("Ordenar vetor- com Insert Short");
	private JButton eraseInPosition = new JButton("Apagar em determinada posição");
	private JButton find = new JButton("Procurar um valor - por força bruta");
	private JButton findByBinary = new JButton("Procurar um valor - por busca binaria");
	private JButton findByBinaryRecursive = new JButton("Procurar um valor - por busca binaria recursiva");
	private JButton howManyEmpty = new JButton("Verificar quantos elementos estão vazios no vetor");
	private JButton howManyOccupied = new JButton("Verificar quantos elementos existem no vetor");
	private JButton biggestElement = new JButton("Verificar o maior elemento do vetor");
	private JButton smallerElement = new JButton("Verificar o menor elemento do vetor");
	private JButton eraseVector = new JButton("Apagar vetor");
	private JButton printVector = new JButton("Mostrar o vetor");
	private JButton exit = new JButton("Sair do programa");
	
	
	private ButtonHandler menu;
	public IGORFARIAScVetor vet;
	
	public Button(IGORFARIAScVetor vetSize) {
		super("Criando botões");
	//	vet = new IGORFARIAScVetor(vetSize);
		
		setLayout(new FlowLayout());
		menu = new ButtonHandler(vetSize, randomVector, randomOrdenatedVector, insertValue, bubbleShort, selectionShort, insertShort, 
				eraseInPosition, find, findByBinary, findByBinaryRecursive, howManyEmpty, howManyOccupied, biggestElement, smallerElement, eraseVector, printVector, exit);
		
		
		randomVector.addActionListener(menu);
		add(randomVector);
		randomOrdenatedVector.addActionListener(menu);
		add(randomOrdenatedVector);
		insertValue.addActionListener(menu);
		add(insertValue);
		bubbleShort.addActionListener(menu);
		add(bubbleShort);
		selectionShort.addActionListener(menu);
		add(selectionShort);
		insertShort.addActionListener(menu);
		add(insertShort);
		eraseInPosition.addActionListener(menu);
		add(eraseInPosition);
		find.addActionListener(menu);
		add(find);
		findByBinary.addActionListener(menu);
		add(findByBinary);
		findByBinaryRecursive.addActionListener(menu);
		add(findByBinaryRecursive);
		howManyEmpty.addActionListener(menu);
		add(howManyEmpty);
		howManyOccupied.addActionListener(menu);
		add(howManyOccupied);
		biggestElement.addActionListener(menu);
		add(biggestElement);
		smallerElement.addActionListener(menu);
		add(smallerElement);
		eraseVector.addActionListener(menu);
		add(eraseVector);
		printVector.addActionListener(menu);
		add(printVector);
		
		exit.addActionListener(menu);
		add(exit);
		
/*		


		"-- 0) sair do programa \n");
implementar o restante do menu
*/	
	}
}
