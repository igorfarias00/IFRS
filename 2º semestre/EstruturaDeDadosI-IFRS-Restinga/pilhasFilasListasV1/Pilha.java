package pilhasFilasListasV1;
//import java.util.LinkedList;
//import java.util.List;

public class Pilha{
	 Lista lista = new Lista();
	 
	 public void adiciona(Object elemento) {
		 lista.adiciona(elemento);
	 }
	 
	 public void remove() {
		 lista.removeDoFim();
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
