package grafo;

public class Aresta {
	public Vertice cidade1;
	public Vertice cidade2;
	public int distancia;			// peso
	
	public Aresta(Vertice cidade1, Vertice cidade2, int distancia) {
		this.cidade1 = cidade1;
		this.cidade2 = cidade2;
		this.distancia = distancia;
	}
	
	public void info_aresta() {
		System.out.println("Conexão vvvvvvvvv");
		this.cidade1.info_vertice();
		this.cidade2.info_vertice();
		System.out.println("distancia: " + this.distancia);
	}
	
}
