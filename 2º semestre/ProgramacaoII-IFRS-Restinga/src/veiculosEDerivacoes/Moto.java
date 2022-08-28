package veiculosEDerivacoes;

public class Moto extends VeiculoTerrestres{
	int cilindrada;
	
	
	public Moto(String fabricante, 
			   String modelo, 
			   String pais,  
			   double valor, 
			   int passageiros, 
			   int anoFab,
			   String dono, 
			   int cilindrada) {
		super(fabricante, modelo, pais, valor, passageiros, anoFab, dono);
		this.setCilindrada(cilindrada);
	}
	
	
	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}
	
	public int getCilindrada() {
		return this.cilindrada;
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
		System.out.println("Cilindrada: " + this.getCilindrada());
		System.out.println("==========================================================================");	
	}
}
