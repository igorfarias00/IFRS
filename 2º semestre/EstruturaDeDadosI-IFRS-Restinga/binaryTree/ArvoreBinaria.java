package binaryTree;

public class ArvoreBinaria {
	No raiz;
	
	public ArvoreBinaria() {
		this.raiz = null;
	}
	
	private Item procurar(Item reg, No raiz) {
		if(reg == null) {
			return null;
		} else if(reg.compara(raiz.elemento) < 0) {
			return procurar(reg, raiz.esquerda);
		} else if(reg.compara(raiz.elemento) > 0) {
			return procurar(reg, raiz.direita);
		} else {
			return raiz.elemento;
		}
	}
	
	private No insere(Item elemento, No p) {
		if(p == null) {
			p = new No();
			p.elemento = elemento;
			p.direita = p.esquerda = null;
		} else if(elemento.compara(p.elemento) < 0) {
			p.esquerda = insere(elemento, p.esquerda);
		} else if(elemento.compara(p.elemento) > 0) {
			p.direita = insere(elemento, p.direita);
		} else {
			System.out.println("Erro: registro já existe");
		}
		
		return p;
	}
	
	public Item procurar(Item elemento) {
		return this.procurar(elemento, this.raiz);
	}
	
	
	void insere(Item elemento) {
		this.raiz = this.insere(elemento, this.raiz);
	}
	
	public void imprime() {
		this.emOrdem(this.raiz);
	}
	
	private void emOrdem(No p) {
		if(p != null) {
			emOrdem (p.esquerda);								//percorre a subarvore da esquerda
			System.out.println(p.elemento.recuperaChave());		// elemento
			emOrdem (p.direita);								//percorre a subarvore da direita
		}
	}
	
	public void remove(Item elemento) {
		this.raiz = this.remove(elemento, this.raiz);
	}

	private No antecessor(No q, No r) {
		if(r.direita != null) {
			r.direita = antecessor (q, r.direita);
		} else {
			q.elemento = r.elemento;
			r = r.esquerda;
		}
		
		return r;
	}
	
	private No remove(Item reg, No p) {
		if(p == null) {
			System.out.println("Erro: registro não encontrado");
		} else if(reg.compara(p.elemento) < 0) {
			p.esquerda = remove(reg, p.esquerda);
		} else if(reg.compara(p.elemento) > 0) {
			p.direita = remove(reg, p.direita);
		} else {
			if(p.direita == null) {
				p = p.esquerda;
			} else if(p.esquerda == null) {
				p = p.direita;
			} else {
				p.esquerda = antecessor (p, p.esquerda);
			}
		}
		return p;
	}
	
	
	

}
