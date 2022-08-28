// feito por igor balest farias na aula de programação II do IFRS - restinga
package metodos;

public class Livro {
	String titulo, editora, autor;
	int isbn, estoque;
	double valor;
	
	
	public Livro (String titulo, String editora, String autor, int isbn, int estoque, double valor) {
		this.titulo = titulo;
		this.editora = editora;
		this.autor = autor;
		this.isbn = isbn;
		this.estoque = estoque;
		this.valor = valor;
	}
	
	public void info() {
		System.out.println("Titulo: "+ this.titulo);
		System.out.println("Editora: "+ this.editora);
		System.out.println("Autor: "+ this.autor);
		System.out.println("ISBN: "+ this.isbn);
		System.out.println("Estoque:  "+ this.estoque);
		System.out.println("Valor: "+ this.valor);
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
