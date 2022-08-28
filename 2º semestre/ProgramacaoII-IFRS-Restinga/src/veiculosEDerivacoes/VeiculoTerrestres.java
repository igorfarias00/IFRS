package veiculosEDerivacoes;
import java.util.Random;

public class VeiculoTerrestres extends Veiculo{
	private int placa;
	private String dono;
	Random generator = new Random();
	
	public VeiculoTerrestres(String fabricante, 
			   String modelo, 
			   String pais,  
			   double valor, 
			   int passageiros, 
			   int anoFab,
			   String dono) {
		super(fabricante, modelo, pais, valor, passageiros, anoFab);
		this.emplacamento();
		this.compra(dono);

	}
	
	public void emplacamento() {
		System.out.println("placa cadastrada");
		this.setPlaca(generator.nextInt(9999));
	}
	
	public void setPlaca(int placa) {
		this.placa = placa;
	}
	
	public int getPlaca() {
		return this.placa;
	}
	
	public String getDono() {
		return this.dono;
	}
	
	public void compra(String dono) {
		this.setDono(dono);
		System.out.println("Dono atualizado!");
	}
	
	public void setDono(String dono){
		this.dono = dono;
	}
	
	@Override
	public void info() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("Fab/Mod: "+ super.getFabricante() + " / " + super.getModelo() + "\n");
		System.out.println("Pais de origem: " + super.getPais());
		System.out.println("Ano de fabricação: " + super.getAnoFab());
		System.out.println("Valor: " + super.getValor());
		System.out.println("Quantidade de passageiros: " + super.getNumPassageiros());
		System.out.println("Placa: " + this.getPlaca());
		System.out.println("==========================================================================");
	}
	
	
}
