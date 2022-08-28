import javax.swing.JOptionPane;
import java.util.Random;


public class IGORFARIAScVetor {

	public int vetorInterno[];
	
	public IGORFARIAScVetor(int vetSize) {
		this.vetorInterno = new int[vetSize];
		
		this.populateVectorWithZero();
	}

	
	public void populateVectorWithZero() {

		for(int i = 0; i < this.vetorInterno.length; i++) {
			this.vetorInterno[i] = 0;
		}
		
		System.out.println("Vetor criado e povoado.");
	}
	
	public void randomOrdenatedVector() {
		// sorteio entre 0 - 200 e soma com a posi��oo anterior do vetor
		Random generator = new Random();
		
		for(int i = 0;i <  this.vetorInterno.length; i++) {
			if(i==0) {
				this.vetorInterno[i] = generator.nextInt(50);
			} else {
				this.vetorInterno[i] = this.vetorInterno[i-1] + generator.nextInt(200);
			}
		}
	}
	
	
	public void randomVector() {
		Random generator = new Random();
		boolean foundEqual= false;
		int value = generator.nextInt(this.vetorInterno.length * 2 + 1), i = 0;
		
		do {
		for(i = 0; i < this.vetorInterno.length; i++) {
			for(int j = 0; j < this.vetorInterno.length; j++) {
				if(value == this.vetorInterno[j]) {
					value = generator.nextInt(this.vetorInterno.length * 2 + 1);
					foundEqual = true;
				}
			}
			if (foundEqual == false) {
				this.vetorInterno[i] = value;
				value = generator.nextInt(this.vetorInterno.length * 2 + 1);
			} else {
				generator.nextInt(this.vetorInterno.length * 2 + 1);
				foundEqual = false;
			}
		}
		} while (foundEqual == false && i < this.vetorInterno.length);
	}
	
	public void insertValue(int pos, int value) {
		pos--;
		if(pos <  this.vetorInterno.length && pos >= 0 ) {
			this.vetorInterno[pos] = value;
		} else {
			System.out.println("posição informado fora do range do vetor");
			JOptionPane.showMessageDialog(null, "posição informado fora do range do vetor");
		}
	}
	
	
	
	public void eraseInPosition(int pos) {
		this.vetorInterno[pos] = 0;
		System.out.printf("posição "+ (pos-1) + " foi apagada!\n");
	}

	

	public void find(int value) {
		String message = "O valor informado está na posição ";
		boolean found = false;
		int i = 0;
		for(i=0; i < this.vetorInterno.length; i++) { // alterar o final do la�o, encontrar uma fun��o para passar o tamanho maximo do vetor neste la�o
			if(this.vetorInterno[i] == value && found == false) {
				found = true;
				System.out.println(i+1);			//se encontrou retorna o valor da posi��o no vetor
				message += Integer.toString((i+1));
				
				JOptionPane.showMessageDialog(null, message);
			}
		} 
				
	}

	public int findByBinary(int value) {
		int start = 0, end = this.vetorInterno.length - 1 , middle = 0;
		
		while(start <= end) {
			middle = (start + end) / 2;
			if(value == this.vetorInterno[middle]) {
				return middle;
			}else if(value > this.vetorInterno[middle]) {
				start = middle +1;
			}else {
				end = middle - 1;
			}
		}
		
		return -1;   // caso o valor não seja encontrado retorna -1
	}
	
	public int findByBinaryRecursive(int value) {
		return binaryRecursive(value, 0, (this.vetorInterno.length - 1));
		
	}
	
	public int binaryRecursive(int value, int start, int end) {
		int middle = (start + end) / 2;
		
		if(start > end) {
			return -1;				// caso não ache o valor, retorna -1
		}
		
		if(this.vetorInterno[middle] == value) {
			return middle;
		}
		
		if(this.vetorInterno[middle] < value) {
			return binaryRecursive(value, (middle+1), end);
		} else {
			return binaryRecursive(value, start, (middle-1));
		}
		
	}
	
	public int howManyEmpty() {
		int cont = 0;
		for(int i = 0; i < this.vetorInterno.length; i++) {		// retorna a quantidade de valores zero no vetor
			if(this.vetorInterno[i] == 0) {
				cont += 1;
			}
		}
		return cont;
	}
	
	public int howManyOccupied() {
		int cont = 0;
		for(int i = 0; i < this.vetorInterno.length; i++) {		// retorna a quantidade de valores zero no vetor
			if(this.vetorInterno[i] > 0) {
				cont += 1;
			}
		}
		return cont;
	}
	
	
	public int howManyWithValue() {				// retorna a quantidade de valores diferentes de zero no vetor
		int cont = 0;
		for(int i = 0; i < this.vetorInterno.length; i++) { 
			if(this.vetorInterno[i] != 0) {
				cont += 1;
			}
		}
		return cont;
	}

	public int biggestElement() {
		int biggest = 0, i =0;
		
		for(i = 0; i < this.vetorInterno.length; i++) {
			if(this.vetorInterno[i] > biggest) {
				biggest = this.vetorInterno[i];
			}
		}
		return biggest;
	}

	public int smallerElement() {
		int smaller = 0;
		
		for(int i=0;i < this.vetorInterno.length; i++) {
			if(this.vetorInterno[i] != 0) {
				smaller = this.vetorInterno[i];
			}
		}
		
		for(int i = 0; i < this.vetorInterno.length; i++) { // alterar o final do la�o, encontrar uma fun��o para passar o tamanho maximo do vetor neste la�o
			if(this.vetorInterno[i] < smaller && this.vetorInterno[i] != 0) {
				smaller = this.vetorInterno[i];
			}
		}
		return smaller;
	}
	
	public void bubbleShort() {
		for(int last = this.vetorInterno.length -1; last > 0; last--) {
			for(int i = 0; i < last; i++) {
				if(this.vetorInterno[i] > this.vetorInterno[i+1]) {
					changePosition(i, i+1);
				}
			}
		}
	}
	
	public void changePosition(int i, int j) {
		int aux =  this.vetorInterno[i];
		this.vetorInterno[i] = this.vetorInterno[j];
		this.vetorInterno[j] = aux;
	}
	
	public void insertShort() {
		int x, j;
		for(int i = 1; i < this.vetorInterno.length; i++) {
			x = this.vetorInterno[i];
			j = i - 1;
			while(j >= 0 && this.vetorInterno[j] > x) {
				this.vetorInterno[j+1]= this.vetorInterno[j];
				j = j - 1;
			}
			
			this.vetorInterno[j + 1] = x;
		}
	}
	
	public void selectionShort() {
		for (int i =0; i < this.vetorInterno.length; i++){
			int smaller = i;
			for (int j = i + 1; j < this.vetorInterno.length; j++) {
				if (this.vetorInterno[j] < this.vetorInterno[smaller]) {
					smaller = j;
				}
			}
			changePosition(i, smaller);
		}
	}
	
	public int vectorLength() {
		return this.vetorInterno.length;		//retorna o tamanho do vetor
	}
	
	public void eraseVector() {
		for(int i = 0; i < this.vetorInterno.length; i++) {
			this.vetorInterno[i] = 0;
		}
	}
	

	public void printVector() {
		String message = "";
		
		for(int i = 0; i < this.vetorInterno.length; i++) {
			if(i%20==0 && i!=0) {
				message += "\n";
				System.out.println();
			}
			System.out.printf(vetorInterno[i]+ " ");
			message += Integer.toString(vetorInterno[i]) + " - ";
		}
		
		JOptionPane.showMessageDialog(null, message);
		
		System.out.println();
	}

}