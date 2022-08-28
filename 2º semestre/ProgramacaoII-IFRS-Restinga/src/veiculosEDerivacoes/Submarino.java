package veiculosEDerivacoes;

public class Submarino extends VeiculoMaritmo{
	int posZ;
	int profundidadeMax;
	
	public Submarino(String fabricante, 
			   String modelo, 
			   String pais,  
			   double valor, 
			   int passageiros, 
			   int anoFab,
			   String novaEmpresa,
			   int profundidadeMax) {
		super(fabricante, modelo, pais, valor, passageiros, anoFab, novaEmpresa);
		this.setPosZ(0);
		this.setProfundidadeMax(profundidadeMax);
	}
	
	public void setPosZ(int z) {
		this.posZ = z;
	}
	
	public int getPosZ() {
		return this.posZ;
	}
	
	public void setProfundidadeMax(int profundidadeMax) {
		this.profundidadeMax = profundidadeMax;
	}
	
	public int getProfundidadeMax() {
		return this.profundidadeMax;
	}
	
	
	
	public void deslocamento(int posX, int posY, int posZ) {
		this.setPosY(this.getPosY() + posY);	
		this.setPosX(this.getPosX() + posX);	
		this.setPosZ(this.getPosZ() + posZ);	
	}
	
	@Override
	public void posicao() {
		System.out.println("Posição X: " + this.getPosX());
		System.out.println("Posição Y: " + this.getPosY());
		System.out.println("Posição Z: " + this.getPosZ());
	}
	
	@Override
	public void info() {
		System.out.print("Fab/Mod: "+ this.getFabricante() + " / " + this.getModelo() + "\n");
		System.out.println("Pais de origem: " + this.getPais());
		System.out.println("Ano de fabricação: " + this.getAnoFab());
		System.out.println("Valor: " + this.getValor());
		System.out.println("Quantidade de passageiros: " + this.getNumPassageiros());
		System.out.println("Nome da empresa proprietaria: " + this.getEmpresa());
		System.out.println("Profundidade Maxima: " + this.getProfundidadeMax());
	}
	
}
