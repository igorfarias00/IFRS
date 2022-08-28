package veiculosEDerivacoes;

public class Navio extends VeiculoMaritmo{
	private String nome;
	
	public Navio(String fabricante, 
			   String modelo, 
			   String pais,  
			   double valor, 
			   int passageiros, 
			   int anoFab,
			   String novaEmpresa,
			   String nome) {
		super(fabricante, modelo, pais, valor, passageiros, anoFab, novaEmpresa);
		this.setNome(nome);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return this.nome;
	}
	
	@Override
	public void info() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.print("Fab/Mod: "+ super.getFabricante() + " / " + super.getModelo() + "\n");
		System.out.println("Pais de origem: " + super.getPais());
		System.out.println("Ano de fabricação: " + super.getAnoFab());
		System.out.println("Valor: " + super.getValor());
		System.out.println("Quantidade de passageiros: " + super.getNumPassageiros());
		System.out.println("Nome da empresa proprietaria: " + super.getEmpresa());
		System.out.println("Nome do Navio: " + this.getNome());
		System.out.println("==========================================================================");
			
	}


}
