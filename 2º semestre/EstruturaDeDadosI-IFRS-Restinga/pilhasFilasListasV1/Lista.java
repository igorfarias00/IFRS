 /*  Código feito por igor balest farias, para a cadeira de programação II do IFRS - campus restinga*/
package pilhasFilasListasV1;

public class Lista {
	private Nodo primeira = null;
	private Nodo ultima = null;
	private int totalDeElementos = 0;
	
	public void adicionaNoComeco(Object elemento) {
		if(this.totalDeElementos == 0) {
			Nodo nova = new Nodo(elemento);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			Nodo nova = new Nodo(elemento, this.primeira);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		
		this.totalDeElementos++;
	}
	
	public void adiciona(Object elemento) {
		if(this.totalDeElementos == 0) {
			adicionaNoComeco(elemento);
		} else {
			Nodo nova = new Nodo(elemento);
			this.ultima.setProximo(nova);
			nova.setAnterior(this.ultima);
			this.ultima = nova;
			
			this.totalDeElementos++;
		}
	}
	
	public void adiciona(int posicao, Object elemento) {
		if(!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao inexistente");
		} else {
			if(posicao == 0) {
				adicionaNoComeco(elemento);
			} else if(posicao == this.totalDeElementos) {
				this.adiciona(elemento);
			} else {
				Nodo anterior = pegaNodo(posicao - 1);
				Nodo proximo = anterior.getProximo();
				Nodo nova = new Nodo(elemento, anterior.getProximo());
				
				// altera a referencia do anterior no elemento inserido e altera a referencia do proximo no elemento anterior
				nova.setAnterior(anterior);
				anterior.setProximo(nova);
				// altera a referencia do proximo no elemento inserido
				nova.setProximo(proximo);
				proximo.setAnterior(nova);
				
				this.totalDeElementos++;
			}
		}
	}
	
	private boolean posicaoOcupada(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}
	
	private Nodo pegaNodo(int posicao) {
		if(!posicaoOcupada(posicao)) {
			throw new IllegalArgumentException("Posicao inexistente");
		}
		
		Nodo atual = primeira;
		
		for(int i = 0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		
		return atual;
	}
	

	
	
	public Object pega(int posicao) {
		return this.pegaNodo(posicao).getElemento();
	}
	
	public void removeDoComeco() {
		if(this.totalDeElementos == 0) {
			return;
		}
		
		this.primeira = this.primeira.getProximo();
		this.totalDeElementos--;
		
		if(this.totalDeElementos == 0){
			this.ultima = null;
		}
	}
	
	public void removeDoFim() {
		if(this.totalDeElementos == 1) {
			this.removeDoComeco();
		} else {
			Nodo penultima = this.ultima.getAnterior();
			penultima.setProximo(null);
			this.ultima = penultima;
			
			this.totalDeElementos--;
		}
	}
	
	public void remove(int posicao) {
		//posicao--;
		if(posicao == 0) {
			this.removeDoComeco();
		} else if(posicao == this.totalDeElementos - 1) {
			this.removeDoFim();
		} else {
			Nodo anterior = this.pegaNodo(posicao - 1);
			Nodo atual = anterior.getProximo();
			Nodo proximo = atual.getProximo();
			
			anterior.setProximo(proximo);
			proximo.setAnterior(anterior);
			
			this.totalDeElementos--;
			
		}
	}
	
	public int tamanho() {
		return this.totalDeElementos;
	}
	
	public boolean contem(Object elemento) {
		Nodo atual = this.primeira;
		
		while (atual != null) {
			if(atual.getElemento().equals(elemento)) {
				return true;
			}
			
			atual = atual.getProximo();
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		//int i = 0;
		if(this.totalDeElementos == 0) {
			return"[ ]";
		}
		
		Nodo atual = primeira;
		
		StringBuilder builder = new StringBuilder("[");
		

		for(int i = 0;i < this.totalDeElementos - 1 ;i++) {
			builder.append(atual.getElemento());
			builder.append(", ");
			if(atual.getProximo() != null) {
				atual = atual.getProximo();
			}
		}
		 
		builder.append(atual.getElemento());
		builder.append("]");
		
		return builder.toString();
	}
	
	public Nodo getPrimeira() {
		return this.primeira;
	}
	
	public Nodo getUltima() {
		return this.ultima;
	}
	

}