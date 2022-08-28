package petShopV1;
import java.util.ArrayList;

public class Pet {
	private String especie;
	private String raca;
	private String nome;
	private int idade;
	private ArrayList<Tutor> tutores;
	
	public Pet(String novoNome, String novaEspecie, String novaRaca, int novaIdade) {
		tutores = new ArrayList<>();
		this.setNome(novoNome);
		this.setEspecie(novaEspecie);
		this.setRaca(novaRaca);
		this.setIdade(novaIdade);
	}
	
	public String info_pet() {
		String str = "";
		
		str += "Nome do pet: " + this.getNome();
		str += "Especie: " + this.getEspecie();
		str += "Raca: " + this.getRaca();
		str += "idade: " + this.getIdade();
		
		return str;
	}
	
	public String info_tutores() {
		String str = "Tutores: \n ";
		for(int i =0; i< this.tutores.size(); i++) {
			str += this.tutores.get(i).info_tutor() + "\n";
		}
		
		return str;
	}
	
	// getters e setters <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public String getEspecie() {
		return this.especie;
	}
	
	public void setEspecie(String novaEspecie) {
		this.especie = novaEspecie;
	}
	
	public String getRaca() {
		return this.raca;
	}
	
	public void setRaca(String novaRaca) {
		this.raca = novaRaca;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}
	
	public int getIdade() {
		return this.idade;
	}
	
	public void setIdade(int novaIdade) {
		this.idade = novaIdade;
	}
	
	public Tutor getTutor(int tutor) {
		return this.tutores.get(tutor);
	}
	
	public void setTutor(int indice, Tutor tutor) {
		this.tutores.set(indice, tutor);

	}
	
	public void addTutor(Tutor tutor) {
		this.tutores.add(tutor);
	}
	
	public int quantTutores() {
		return this.tutores.size();
	}
}
