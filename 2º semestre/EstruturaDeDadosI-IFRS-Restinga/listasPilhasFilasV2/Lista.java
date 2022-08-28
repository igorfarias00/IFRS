  
package listasPilhasFilasV2;

public class Lista {
	private Nodo primeiro;
	private Nodo ultimo;
	int totalDeElementos;
	
	
	public Lista() {
		this.setPrimeiro(null);
		this.setUltimo(null);
		this.totalDeElementos = 0;
	}
	
	
	public void adiciona(int novoElemento) {
		Nodo novoNodo = new Nodo(novoElemento);
		this.adiciona(novoNodo, this.getPrimeiro());
	}
	
	private void adiciona(Nodo novoNodo, Nodo nodoCorrente) {
		
		Nodo temp;
		
		if(this.getPrimeiro() == null) {
			this.setPrimeiro(novoNodo);
			
		} else {
			if(this.primeiro.getElemento() > novoNodo.getElemento()) {
				nodoCorrente.setAnterior(novoNodo);
				this.setPrimeiro(novoNodo);
				
			} else if(nodoCorrente.getProximo() == null && nodoCorrente.getElemento() <= novoNodo.getElemento()) {
				nodoCorrente.setProximo(novoNodo);
				novoNodo.setAnterior(nodoCorrente);
				this.setUltimo(novoNodo);
				
			} else if (nodoCorrente.getProximo() != null && nodoCorrente.getElemento() <= novoNodo.getElemento()){
				this.adiciona(novoNodo, nodoCorrente.getProximo());
					
			} else if(nodoCorrente.getElemento() >= novoNodo.getElemento()){
				temp = nodoCorrente.getAnterior();
				novoNodo.setProximo(nodoCorrente);
				novoNodo.setAnterior(temp);
				temp.setProximo(novoNodo);
				nodoCorrente.setAnterior(novoNodo);
				
				
			} else {
				this.adiciona(novoNodo, nodoCorrente.getProximo());
			}
		}
	}
	
	
	
	public void remove(int elemento) {
		if(this.getPrimeiro() == null) {
			System.out.println("Lista esta vazia");
		} else {
			this.remove(elemento, this.getPrimeiro());
		}
	}
	
	private void remove(int elemento, Nodo nodoCorrente) {
		Nodo anterior = nodoCorrente.getAnterior();
		Nodo proximo = nodoCorrente.getProximo();
		if(nodoCorrente.getElemento() < elemento) {
			this.remove(elemento, nodoCorrente.getProximo());
		} else if(nodoCorrente.getElemento() == elemento) {
			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);
			
		} else if(nodoCorrente.getElemento() == this.getUltimo().getElemento() && nodoCorrente.getElemento() < elemento) {
			System.out.println("Elemento não está na lista");
		}
		
	}
	
	
	public void mostraLista() {
		this.mostraLista(this.getPrimeiro());
		System.out.println();
	}
	
	private void mostraLista(Nodo nodoCorrente) {
		if(nodoCorrente != null) {
			System.out.printf(" -- " + nodoCorrente.getElemento());
			
			//if(nodoCorrente.getAnterior() != null) {
			//	System.out.println("Nodo anterior: " + nodoCorrente.getAnterior().getElemento());
			//}
			//System.out.println(nodoCorrente);
			mostraLista(nodoCorrente.getProximo());
		}

	}
	
	public void setPrimeiro(Nodo primeiroNodo) {
		this.primeiro = primeiroNodo;
		
	}
	
	public Nodo getPrimeiro() {
		return this.primeiro;
	}
	
	
	public Nodo getUltimo() {
		return this.ultimo;
	}
	
	public void setUltimo(Nodo novoUltimo) {
		this.ultimo = novoUltimo;
	}

}