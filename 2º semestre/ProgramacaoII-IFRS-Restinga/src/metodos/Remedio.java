// feito por igor balest farias na aula de programação II do IFRS - restinga
package metodos;

public class Remedio {
	String nome, tarja, laboratorio;
	double valor;
	int estoque;
	
	public Remedio(String nome, String tarja, String laboratorio, double valor, int estoque) {
		this.nome = nome;
		this.tarja = tarja;
		this.laboratorio = laboratorio;
		this.valor = valor;
		this.estoque = estoque;
	}
	
	public void info() {
		System.out.println("nome do remedio: "+ this.nome);
		System.out.println("Tarja: "+ this.tarja);
		System.out.println("Laboratorio: "+ this.laboratorio);
		System.out.println("Valor: "+ this.valor);
		System.out.println("Estoque: " + this.estoque);
	}
	
	public void novoValor(double novoValor) {
		this.valor = novoValor;
	}
	
	public void novoEstoque(int remessa) {
		this.estoque = remessa;
	}
	
	public void incrementeEstoque(int remessa) {
		this.estoque += remessa;
	}
	
	public void decrementaEstoque(int retirada) {
		this.estoque -= retirada;
	}
}
