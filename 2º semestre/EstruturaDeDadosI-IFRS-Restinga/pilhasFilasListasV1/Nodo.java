 /*  Código feito por igor balest farias, para a cadeira de programação II do IFRS - campus restinga*/
package pilhasFilasListasV1;


public class Nodo {
	private Object elemento;
		
	private Nodo proximo;
	private Nodo anterior;
		
	public Nodo(Object elemento) {
		this(elemento, null);
	}
		
	public Nodo(Object elemento, Nodo proximo) {
		this.elemento = elemento;
		this.proximo = proximo;
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
		
	public Object getElemento() {
		return elemento;
	}
		
}
