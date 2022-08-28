package veiculosEDerivacoes;

public class Carro extends VeiculoTerrestres{
	int combustivel;
	String classe;
	int potencia;
	
	public Carro(String fabricante, 
			String modelo, 
			String pais,  
			double valor, 
			int passageiros, 
			int anoFab,
			String novoDono,
			int potencia,
			String classe,
			int combustivel) {
		super(fabricante, modelo, pais, valor, passageiros, anoFab, novoDono);
		this.setClasse(classe);
		this.setPotencia(potencia);
		this.setCombustivel(combustivel);
	}
	
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	public int getPotencia() {
		return this.potencia;
	}
	
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getClasse() {
		return this.classe;
	}
	
	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}
	
	public int getCombustivel() {
		return this.combustivel;
	}
	
	@Override
	public void info() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("Fab/Mod: "+ super.getFabricante() + " / " + super.getModelo() + "\n");
		System.out.println("Pais de origem: " + super.getPais());
		System.out.println("Ano de fabricação: " + super.getAnoFab());
		System.out.println("Valor: " + super.getValor());
		System.out.println("Quantidade de passageiros: " + super.getNumPassageiros());
		System.out.println("Placa: " + super.getPlaca());
		System.out.println("Potencia: " + this.getPotencia());
		System.out.println("Capacidade do tanque de combustivel: " + this.getCombustivel());
		System.out.println("Classe: " + this.getClasse());
		System.out.println("==========================================================================");
	}
}
