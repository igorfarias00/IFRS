package veiculosEDerivacoes;
import java.util.Random;
public class VeiculoAereo extends Veiculo{
	private int codigo;
	private int posZ;
	private String empresa;
	Random generator = new Random();
	
	
	public VeiculoAereo(String fabricante, 
			   String modelo, 
			   String pais,  
			   double valor, 
			   int passageiros, 
			   int anoFab,
			   String novaEmpresa) {
		super(fabricante, modelo, pais, valor, passageiros, anoFab);
		this.compra(novaEmpresa);
		this.setPosZ(0);
		
	}
	

	public void deslocamento(int posX, int posY ,int posZ) {
		this.setPosZ(this.getPosZ() + posZ);
		super.setPosX(super.getPosX() + posX);
		super.setPosY(super.getPosY() + posY);
	}
	
	public int getPosZ() {
		return this.posZ;
	}
	
	public void setPosZ(int posZ) {
		this.posZ = posZ;
	}
	
	public void compra(String novaEmpresa) {
		this.setEmpresa(novaEmpresa);
		System.out.println("Empresa atualizada com sucesso!");
		this.setCodigo(generator.nextInt(9999));
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return this.codigo;
	}
	
	public String getEmpresa() {
		return this.empresa;
	}
	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	@Override
	public void info() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("Fab/Mod: "+ super.getFabricante() + " / " + super.getModelo() + "\n");
		System.out.println("Pais de origem: " + super.getPais());
		System.out.println("Ano de fabricação: " + super.getAnoFab());
		System.out.println("Valor: " + super.getValor());
		System.out.println("Quantidade de passageiros: " + super.getNumPassageiros());
		System.out.println("codigo: " + this.getCodigo());
		System.out.println("Empresa: "+ this.getEmpresa());
		System.out.println("==========================================================================");
	}
}
