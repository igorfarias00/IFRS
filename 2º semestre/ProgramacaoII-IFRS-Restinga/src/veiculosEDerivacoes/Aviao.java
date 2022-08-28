package veiculosEDerivacoes;

public class Aviao extends VeiculoAereo {
	private boolean supersonico;
	private int velocidadeMax;
	
	
	public Aviao(String fabricante, 
				 String modelo, 
				 String pais,
				 double valor, 
				 int passageiros, 
				 int anoFab,
				 String novaEmpresa,
				 int velocidadeMax) {
		super(fabricante, modelo, pais, valor, passageiros, anoFab, novaEmpresa);
		this.setVelocidadeMax(velocidadeMax);
		
	}
	
	public void setVelocidadeMax(int velocidadeMax){
		if(velocidadeMax >= 1235) {
			this.setSupersonico(true);
			this.velocidadeMax = velocidadeMax;
		} else {
			this.setSupersonico(false);
			this.velocidadeMax = velocidadeMax;
		}
	}
	
	public void setSupersonico(boolean ser) {
		this.supersonico = ser;
	}
	
	public boolean getSupersonico() {
		return this.supersonico;
	}
	
	public int getVelocidadeMax() {
		return this.velocidadeMax;
	}
	
	@Override
	public void info() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("Fab/Mod: "+ super.getFabricante() + " / " + super.getModelo() + "\n");
		System.out.println("Pais de origem: " + super.getPais());
		System.out.println("Ano de fabricação: " + super.getAnoFab());
		System.out.println("Valor: " + super.getValor());
		System.out.println("Quantidade de passageiros: " + super.getNumPassageiros());
		System.out.println("codigo: " + super.getCodigo());
		System.out.println("Empresa: "+ super.getEmpresa());
		System.out.println("Supersonico: " + this.getSupersonico());
		System.out.println("Velocidade Maxima: "+ this.getVelocidadeMax());
		System.out.println("==========================================================================");
	}
	
	
}
