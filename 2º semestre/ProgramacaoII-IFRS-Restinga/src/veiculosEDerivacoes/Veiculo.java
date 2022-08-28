package veiculosEDerivacoes;

public class Veiculo {
	private String fabricante;
	private String modelo;
	private String pais;
	private int posX;
	private int posY;
	private double valor;
	private int numPassageiros;
	private int anoFab;
	
	public Veiculo(String fabricante, 
				   String modelo, 
				   String pais,  
				   double valor, 
				   int passageiros, 
				   int anoFab) {
		
		this.setFabricante(fabricante);
		this.setModelo(modelo);
		this.setPais(pais);
		this.setPosX(0);
		this.setPosY(0);
		this.setValor(valor);
		this.setNumPassageiros(passageiros);
		this.setAnoFab(anoFab);
		
	}
	
	public void deslocamento(int posX, int posY, int z) {
		this.setPosX(this.getPosX() + posX);
		this.setPosY(this.getPosY() + posY);
	}
	
	public String getFabricante() {
		return fabricante;
	}
	
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public void setAnoFab(int ano) {
		this.anoFab = ano;
	}
	
	public int getAnoFab() {
		return anoFab;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public String getPais() {
		return this.pais;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public void setNumPassageiros(int passageiros) {
		this.numPassageiros = passageiros;
	}
	
	public int getNumPassageiros() {
		return this.numPassageiros;
	}
	
	public void setPosY(int y) {
		this.posY = y;
	}
	
	public void setPosX(int x) {
		this.posX = x;
	}
	
	public int getPosY() {
		return this.posY;
	}
	
	public int getPosX() {
		return this.posX;
	}
	
	public void posicao() {
		System.out.println("Posição X: " + this.getPosX());
		System.out.println("Posicão Y: " + this.getPosY());
	}
	

	public void info() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("Fab/Mod: "+ this.getFabricante() + " / " + this.getModelo() + "\n");
		System.out.println("Pais de origem: " + this.getPais());
		System.out.println("Ano de fabricação: " + this.getAnoFab());
		System.out.println("Valor: " + this.getValor());
		System.out.println("Quantidade de passageiros: " + this.getNumPassageiros());
		System.out.println("==========================================================================");
		
	}
}
