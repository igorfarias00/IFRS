 /*  Código feito por igor balest farias, para a cadeira de programação II do IFRS - campus restinga
 * 
 * 
 */

package livraria;



import java.util.ArrayList;

public class Livros {
	private String titulo;
	private String editora;
	private String area;
	private int ano;
	private double valor;
	ArrayList<Livros> produtos = new ArrayList<>();
	
	
	public Livros(String titulo, String editora, String area, int ano, double valor) {
		this.setTitulo(titulo);
		this.setEditora(editora);
		this.setArea(area);
		this.setAno(ano);
		this.setValor(valor);
	}
	
	
	public void apresentaLivro() {
		System.out.println("Titulo: " +this.getTitulo());
		System.out.println("Editora: " + this.getEditora());
		System.out.println("Categoria: " + this.getArea());
		System.out.println("Ano: "+ this.getAno());
		System.out.println("Valor: R$" + this.getValor());
		System.out.println("-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-#-");
	}
	

	public boolean buscaPorTitulo(String titulo) {
		if(this.getTitulo().equals(titulo)) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean buscaPorArea(String categoria) {
		if(this.getArea().equals(categoria)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	public boolean buscaPorPreco(double valor) {
		if(this.getValor() <= valor) {
			return true;
		} else { 
			return false;
		}
	}
	
	public double getValor() {
		return this.valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getAno() {
		return this.ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getArea() {
		return this.area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getEditora() {
		return this.editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getTitulo() {
		return this.titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
}
