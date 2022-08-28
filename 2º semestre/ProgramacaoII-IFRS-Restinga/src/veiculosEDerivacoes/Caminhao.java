package veiculosEDerivacoes;

public class Caminhao extends VeiculoTerrestres{
	private int quant_eixos, capacidade, carga;
	private boolean comCarga;
	
	public Caminhao(String fabricante, 
					String modelo, 
					String pais,  
					double valor, 
					int passageiros, 
					int anoFab,
					String novoDono) {
		super(fabricante, modelo, pais, valor, passageiros, anoFab, novoDono);
		
		this.setQuant_eixos(quant_eixos);
		this.setCapacidade(capacidade);
	}

	public int getQuant_eixos() {
		return this.quant_eixos;
	}

	public void setQuant_eixos(int quant_eixos) {
		this.quant_eixos = quant_eixos;
	}
	
	public void setCapacidade(int valor) {
		this.capacidade = valor;
	}
	
	public int getCapacidade() {
		return this.capacidade;
	}
	
	
	public void carga(int pesoDaCarga) {
		if(this.getCapacidade() >= pesoDaCarga) {
			this.setComCarga(true);
			this.setCarga(pesoDaCarga);
		} else {
			System.out.println("Peso da carga acima da capacidade");
		}
	}
	
	public void descarregar() {
		this.setCarga(0);
		this.setComCarga(false);
	}
	
	public void setCarga(int pesoDaCarga) {
		this.carga = pesoDaCarga;
	}
	
	public void setComCarga(boolean estado) {
		this.comCarga = estado;
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
		System.out.println("Quantidade de eixos: " + this.getQuant_eixos());
		System.out.println("Capacidade de peso: " + this.getCapacidade());
		System.out.println("==========================================================================");	
	}
	
}
