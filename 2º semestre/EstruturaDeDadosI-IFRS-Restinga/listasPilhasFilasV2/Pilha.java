package listasPilhasFilasV2;
//import java.util.LinkedList;
//import java.util.List;

public class Pilha{
	 Lista lista = new Lista();
	 
	 public void adiciona(int elemento) {
		 Nodo novoNodo = new Nodo(elemento);
		 if(lista.getUltimo() != null) {		 
			 lista.getUltimo().setProximo(novoNodo);
			 novoNodo.setAnterior(lista.getUltimo());
			 lista.setUltimo(novoNodo);
			 
		 } else {
			 lista.setPrimeiro(novoNodo);
			 lista.setUltimo(novoNodo);
		 }
	 }
	 
	 public void remove() {
		 if(lista.getUltimo().getAnterior() != null) {
			 Nodo temp = lista.getUltimo().getAnterior();
			 lista.getUltimo().getAnterior().setProximo(null); 
			 lista.setUltimo(temp);
		 } else {
			 lista.setPrimeiro(null);
			 lista.setUltimo(null);
		 }

	 }
	 
	 public void mostraPilha() {
		 lista.mostraLista();

	 }
	 
	 public boolean vazia() {
		 if(lista.getPrimeiro() == null & lista.getUltimo() == null) {
			 return true;
		 } else {
			 return false;
		 }
	 }

}
