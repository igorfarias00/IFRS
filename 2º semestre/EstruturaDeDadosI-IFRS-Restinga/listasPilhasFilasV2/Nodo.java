package listasPilhasFilasV2;


public class Nodo {
	private int elemento;
		
	private Nodo proximo;
	private Nodo anterior;
	
	public Nodo(int novoElemento) {
		this.setElemento(novoElemento);
		this.setAnterior(null);
		this.setProximo(null);
	}
		
	
	public Nodo getProximo() {
		return this.proximo;
	}
		
	public void setProximo(Nodo proximo) {
		this.proximo = proximo;
	}
		
	public Nodo getAnterior() {
		return this.anterior;
	}
		
	public void setAnterior(Nodo anterior) {
		this.anterior = anterior;
	}
		
	public int getElemento() {
		return elemento;
	}
	
	public void setElemento(int novoElemento) {
		this.elemento = novoElemento;
	}
		
}
