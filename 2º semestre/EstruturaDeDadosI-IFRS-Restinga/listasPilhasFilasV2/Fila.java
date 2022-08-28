package listasPilhasFilasV2;

public class Fila {
	Lista lista = new Lista();
	 
	public void adiciona(int elemento) {
		Nodo novoNodo = new Nodo(elemento);
		if(lista.getUltimo() != null) {		 					// se a lista nao estiver vazia
			lista.getUltimo().setProximo(novoNodo);				// atualiza a referencia no proximo no espaço do ultimo da fila 
			novoNodo.setAnterior(lista.getUltimo());			// atualiza a referencia do anterior no novo nodo
			lista.setUltimo(novoNodo);							// atualiza o ultimo da fila
			 
		} else {						
			lista.setPrimeiro(novoNodo);
			lista.setUltimo(novoNodo);
		}
	}
	 
	public void remove() {
		if(lista.getPrimeiro().getProximo() != null) {
			Nodo temp = lista.getPrimeiro().getProximo(); // salva o elemento na segunda posiçao da fila
			temp.setAnterior(null); 					// remove o primeiro elemento  da fila
			lista.setPrimeiro(temp);					// atualiza a posicao do primeiro da fila
		} else {
			lista.setPrimeiro(null);
			lista.setUltimo(null);
		}
		
	}
	 
	 public void mostraFila() {
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
