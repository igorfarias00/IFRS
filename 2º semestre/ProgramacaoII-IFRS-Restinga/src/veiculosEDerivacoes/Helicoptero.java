package veiculosEDerivacoes;

public class Helicoptero extends VeiculoAereo{
	private int rotores;
	
	public Helicoptero(String fabricante, 
			   String modelo, 
			   String pais,
			   int rotores,
			   double valor, 
			   int passageiros, 
			   int anoFab,
			   String novaEmpresa) {
		super(fabricante, modelo, pais, valor, passageiros, anoFab, novaEmpresa);
		this.setRotores(rotores);
	}

	
	public void setRotores(int rotores) {
		this.rotores = rotores;
	}
	
	public int getRotores() {
		return this.rotores;
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
		System.out.println("Rotores: " + this.getRotores());
		System.out.println("==========================================================================");
	}
}
