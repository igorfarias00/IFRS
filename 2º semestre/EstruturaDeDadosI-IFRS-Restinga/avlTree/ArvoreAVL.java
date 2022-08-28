package avlTree;
public class ArvoreAVL {
	No raiz;
	
	public ArvoreAVL() {
			this.raiz = null;
	}
	
	
	public int calcularAltura(No temp) {
		if(temp.filhoEsquerda == null && temp.filhoDireita == null) {
			return 1;
			
		} else if(temp.filhoEsquerda != null && temp.filhoDireita == null) {
			return 1 + calcularAltura(temp.filhoEsquerda);
			
		} else if(temp.filhoEsquerda == null && temp.filhoDireita != null) {
			return 1 + calcularAltura(temp.filhoDireita);
			
		} else {
			return 1 + Math.max(calcularAltura(temp.filhoEsquerda), calcularAltura(temp.filhoDireita));
			
		}
	}
	
	public void calcularBalanceamento(No temp) {
		if(temp.filhoDireita == null && temp.filhoEsquerda == null) {
			temp.balanceamento = 0;
			
		}else if(temp.filhoEsquerda == null && temp.filhoDireita != null) {
			temp.balanceamento = this.calcularAltura(temp.filhoDireita) - 0;
			
		} else if(temp.filhoEsquerda != null && temp.filhoDireita == null) {
			temp.balanceamento = 0 - this.calcularAltura(temp.filhoEsquerda);
			
		}  else {
			temp.balanceamento = this.calcularAltura(temp.filhoDireita) - this.calcularAltura(temp.filhoEsquerda);
			
		}
		
		if(temp.filhoDireita != null) {
			this.calcularBalanceamento(temp.filhoDireita);
		}
		if(temp.filhoEsquerda != null) {
			this.calcularBalanceamento(temp.filhoEsquerda);
		}
	}
	
	
	public No rotacaoSimplesEsquerda(No temp){
		No filhoEsq;
		No filhoDoFilho = null;
		
		filhoEsq = temp.filhoEsquerda;
		if(temp.filhoEsquerda != null) {
			if(temp.filhoEsquerda.filhoDireita != null) {
				filhoDoFilho = filhoEsq.filhoDireita;
			}
		}
		filhoEsq.filhoDireita = temp;
		temp.filhoEsquerda = filhoDoFilho;
		
		return filhoEsq;
	}

	public No  rotacaoDuplaEsquerda(No temp){
		No filhoEsq = temp.filhoEsquerda;
		No filhoDoFilho = filhoEsq.filhoDireita;
		No noInserido = filhoDoFilho.filhoEsquerda;
		
		// >>>> alinhar os nos <<<<
		filhoEsq.filhoDireita = noInserido;
		filhoDoFilho.filhoEsquerda = filhoEsq;
		temp.filhoEsquerda = filhoDoFilho;
		
		// >>>> tornar filho a direita a nova raiz <<<<
		No novoFilhoEsquerda = temp.filhoEsquerda;
		temp.filhoEsquerda = null;
		novoFilhoEsquerda.filhoDireita = temp;
		
		return novoFilhoEsquerda;
	}
	
	
	

	public No rotacaoSimplesDireita(No temp){
		No filhoDir;
		No filhoDoFilho = null;
		
		filhoDir = temp.filhoDireita;
		if(temp.filhoDireita != null) {
			if(temp.filhoDireita.filhoEsquerda != null) {
				filhoDoFilho = filhoDir.filhoEsquerda;
			}
		}
		filhoDir.filhoEsquerda = temp;
		temp.filhoDireita = filhoDoFilho;
		
		return filhoDir;
	}
	
	
	public No rotacaoDuplaDireita(No temp){
		No filhoDir = temp.filhoDireita;
		No filhoDoFilho = filhoDir.filhoEsquerda;
		No noInserido = filhoDoFilho.filhoDireita;
		
		// >>>> alinhar os nos <<<<
		filhoDir.filhoEsquerda = noInserido;
		filhoDoFilho.filhoDireita = filhoDir;
		temp.filhoDireita = filhoDoFilho;
		
		// >>>> tornar filho a direita a nova raiz <<<<
		No novoFilhoDireita = temp.filhoDireita;
		temp.filhoDireita = null;
		novoFilhoDireita.filhoEsquerda = temp;
		
		return novoFilhoDireita;
		
	}

	
	public No verificaBalanceamento(No temp) {
		if(temp.balanceamento >= 2 || temp.balanceamento <= -2) {
			if(temp.balanceamento >= 2) {
				if(temp.balanceamento * temp.filhoDireita.balanceamento > 0) {
					System.out.println("Rotação Simples Direita");
					return rotacaoSimplesDireita(temp);
				} else {
					System.out.println("Rotação Dupla Direita");
					return rotacaoDuplaDireita(temp);
				}
			} else { 	// balanceamento <= -2
				if(temp.balanceamento * temp.filhoEsquerda.balanceamento < 0) {
					System.out.println("Rotação Simples Esquerda");
					return rotacaoSimplesEsquerda(temp);
				} else {
					System.out.println("Rotação Dupla Esquerda");
					return rotacaoDuplaEsquerda(temp);
				}
			}
		}
		
		this.calcularBalanceamento(temp);
		
		if(temp.filhoEsquerda != null) {
			verificaBalanceamento(temp.filhoEsquerda);
		} 
		if(temp.filhoDireita != null) {
			verificaBalanceamento(temp.filhoDireita);
		}
		
		return temp;
	}
	
	private No insere(int elemento, No p) {
		if(p == null) {												// sou uma raiz vazia? 
			p = new No();											// se sim, adiciona o elemento e seta os filhos a esquerda e a direita como nulos
			p.elemento = elemento;
			p.filhoDireita = p.filhoEsquerda = null;
		} else if(p.elemento > elemento) {							// se a raiz não está vazia, o elemento a ser inserido e menor que o elemento guardado?
			p.filhoEsquerda = insere(elemento, p.filhoEsquerda);	// se for menor, passa a referencia da subarvore da esquerda
		} else if(p.elemento < elemento) {
			p.filhoDireita = insere(elemento, p.filhoDireita);		// se for maior, passa a referencia da subarvore da direita
		} else {
			System.out.println("Erro: registro já existe");			// se não, o elemento já existe
		}
		
		return p;
	}
	
	public void insere(int elemento) {
		this.raiz = this.insere(elemento, this.raiz);				// chama  a função de inserção passando a raiz como referencia
		this.calcularBalanceamento(this.raiz);
		this.raiz = this.verificaBalanceamento(this.raiz);
		this.calcularBalanceamento(this.raiz);
	}
	
	private No antecessor(No q, No r) {
		if(r.filhoDireita != null) {
			r.filhoDireita = antecessor (q, r.filhoDireita);
		} else {
			q.elemento = r.elemento;
			r = r.filhoEsquerda;
		}
		
		return r;
	}

	
	private No remove(int elemento, No p) {
		if(p == null) {
			System.out.println("Erro: registro não encontrado");
		} else if(elemento < p.elemento) {
			p.filhoEsquerda = remove(elemento, p.filhoEsquerda);
		} else if(elemento > p.elemento) {
			p.filhoDireita = remove(elemento, p.filhoDireita);
		} else {
			if(p.filhoDireita == null) {
				p = p.filhoEsquerda;
			} else if(p.filhoEsquerda == null) {
				p = p.filhoDireita;
			} else {
				p.filhoEsquerda = antecessor (p, p.filhoEsquerda);
			}
		}
		return p;
	}
	
	public void remove(int elemento) {
		this.raiz = this.remove(elemento, this.raiz);
	}
	
	public void imprime(int opcao) {
		if(opcao == 1) {
			this.emOrdem(this.raiz);
		} else if (opcao == 2) {
			this.posOrdem(this.raiz);
		} else if (opcao == 3) {
			this.preOrdem(this.raiz);
		} else {
			System.out.println("Opção invalida!!");
		}
		
		System.out.println();
	}
	
	private void emOrdem(No p) {
		if(p != null) {
			emOrdem (p.filhoEsquerda);								//percorre a subarvore da esquerda
			System.out.print(p.elemento + " - ");		// elemento
			emOrdem (p.filhoDireita);								//percorre a subarvore da direita
		}
	}
	
	private void preOrdem(No p) {
		if(p != null) {
			System.out.print(p.elemento + " - ");		// elemento
			preOrdem (p.filhoEsquerda);								//percorre a subarvore da esquerda
			preOrdem (p.filhoDireita);								//percorre a subarvore da direita
		}
	}
	
	private void posOrdem(No p) {
		if(p != null) {
			posOrdem (p.filhoEsquerda);								//percorre a subarvore da esquerda
			posOrdem (p.filhoDireita);								//percorre a subarvore da direita
			System.out.print(p.elemento + " - ");		// elemento
		}
	}
	
	public String printArvore() {
		return printArvore(0, this.raiz);
	}
	
	private String printArvore(int level, No temp) {
		String str = "";
		
		
		if(temp != null) {						// se não for vazio, retorno o elemento da posição para ser concatenado
			str = this.toString(temp)+"\n";
		}
		
		for(int i = 0; i < level; i++) {
			str += "\t";
		}
		if(temp.filhoEsquerda != null) {											// se tiver filhos a esquerda, percorre a subarvore
			str += "ESQ -> " + this.printArvore(level + 1, temp.filhoEsquerda);
		} else {
			str += "ESQ -> NULL";
		}
		str += "\n";
		
		for(int i = 0; i < level; i++) {
			str += "\t";
		}		
		if(temp.filhoDireita != null) {
			str += "DIR -> " + this.printArvore(level + 1, temp.filhoDireita);
		} else {
			str += "DIR -> NULL";
		}
		str += "\n";
		
		
		return str;
	}
	

	public String toString(No temp) {
		return "[" + temp.elemento + "] (" + temp.balanceamento + ")";
	}
	
}
