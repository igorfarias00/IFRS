package pilhasFilasListasV1;

public class Fila {
	private Lista lista = new Lista();
	
	public void adiciona(Object elemento) {
		lista.adiciona(elemento);
	}
	
	public void remove() {
		lista.remove(0);
	}
	
	public boolean vazia() {
		if(lista.tamanho() > 0) {
			return false;
		} 
		return true;
	}
	
	@Override
	public String toString() {
		return lista.toString();
	}
	
}
