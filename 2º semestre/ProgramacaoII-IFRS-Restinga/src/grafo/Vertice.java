package grafo;
import java.util.ArrayList;

public class Vertice {
	public String nomeCidade;
	public ArrayList<Vertice> vizinhanca = new ArrayList<Vertice>();	// saida
	public ArrayList<Aresta> conexoes = new ArrayList<Aresta>();		// entrada 
	
	
	public Vertice(String nomeCidade) { 				//construtor
		this.nomeCidade = nomeCidade.toLowerCase();
	}
	
	public void info_vizinhos() {						// mostra os vizinhos dessa aresta
		System.out.println("Vizinhos");				
		for(int i = 0; i < this.vizinhanca.size(); i++) {					// percorre a lista de vizinhos
			System.out.println("> " + this.vizinhanca.get(i).nomeCidade );  // e mostra os nomes
		}
	}
	
	public void info_conexoes() {						// mostra as informações das conexoes
		for(int i = 0; i< this.conexoes.size(); i++) {  //
			this.conexoes.get(i).info_aresta();
		}
	}
	
	public void info_vertice() {
		System.out.println(">>> " + this.nomeCidade);
		
	}
}
