package petShopV1;

import java.util.ArrayList;


public class Tutor extends Pessoa{
	ArrayList<Pet> pets = new ArrayList();

	public Tutor(	String novoNome, 
					int novoCpf, 
					String novoEndereco, 
					String novoEmail, 
					int novoTelefone) {
		super(novoNome, novoCpf, novoEndereco, novoEmail, novoTelefone);
	}
	
	public String info_tutor() {
		return super.info_pessoa();
	}
	
	public String info_pets() {
		String str = "";
		
		for(int i = 0; i < pets.size(); i++) {
			str += "Nome do pet: " + pets.get(i).getNome() + "\n";
			str += "Especie do pet: " + pets.get(i).getEspecie() + "\n";
			str += "Raca do pet: " + pets.get(i).getRaca() + "\n";
			str += "Idade: " + pets.get(i).getIdade() + "\n";
		}
		
		return str;
	}
	
	// getters e setters <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	

	
	public void setPets(int indice, Pet pet) {
		this.pets.set(indice, pet);
	}
	
	public Pet getPet(int indice) {
		return this.pets.get(indice);
	}
	
	public void addPet(Pet novoPet) {
		this.pets.add(novoPet);
	}
	
	
	
}
