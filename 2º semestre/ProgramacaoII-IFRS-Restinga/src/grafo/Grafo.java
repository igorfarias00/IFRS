package grafo;
import java.util.ArrayList;


public class Grafo {
	public ArrayList<Vertice> cidades = new ArrayList<Vertice>();
	public ArrayList<Aresta> conexoes = new ArrayList<Aresta>();
	
	
	public Grafo() {
		
	}
	
	public void info_cidades() {
		for(int i = 0; i < cidades.size(); i++) {
		System.out.println("Cidade " + i + " -> " + this.cidades.get(i).nomeCidade);
		}
	}
	
	public void info_conexoes () {
		
		for(int i = 0; i < this.conexoes.size(); i++) {
			this.conexoes.get(i).info_aresta();
			System.out.println("----------------------------------------");
		}

	}
	
	public void cadastra_cidade(String novaCidade) {
		this.cidades.add(new Vertice(novaCidade));		// cadastra nova cidade
		
	}
	
	public void cadastra_conexao(Vertice cidade1, Vertice cidade2, int distancia) {
		Aresta novaAresta = new Aresta(cidade1, cidade2, distancia);		// cria a aresta da conexão
		this.conexoes.add(novaAresta);										// adiciona a lista

		
		for(int i = 0; i < cidades.size(); i++) {		// percorre as cidades cadastradas
			if(cidade1 == this.cidades.get(i)) {		// verifica se é a primeira cidade procurada 
				this.cidades.get(i).vizinhanca.add(cidade2); // adiciona a cidade2 na vizinhanca da cidade1
				this.cidades.get(i).conexoes.add(novaAresta);
			}
			
			if(cidade2 == this.cidades.get(i)) {			
				this.cidades.get(i).vizinhanca.add(cidade1);	//adiciona a cidade1 na vizinhanca da cidade2
				this.cidades.get(i).conexoes.add(novaAresta);
				
			}
			
		}
		
		
	}
}
