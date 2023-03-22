package br.com.nivelamento.DTO;

import java.util.ArrayList;

public class Telefone {
	private Contato contato_id;
	private ArrayList<String> telefones = new ArrayList<>();
	
	public Telefone(Contato contato) {
		this.setContato_id(contato);
		
	}
	
	public Telefone() {
		
	}
	
	
	
// add telefone
	
	public void addTelefone(String telefone ) {
		this.telefones.add(telefone);
	}
	
// remove telefone
	
	public void removeTelefone(String telefone) {
		for(int i = 0; i < telefones.size(); i++) {
			if(telefones.get(i) == telefone) {
				this.telefones.remove(i);
			}
			
		}
	}

// return 1 telefone 
	
	public String getTelefone(String telefone) {
		int position = -1;
		for(int i = 0; i < telefones.size(); i++) {
			if(telefones.get(i) == telefone) {
				position = i;
			}
			
		}
		if(position == -1) {
			return "N�o encontrou nenhum numero igual ao inserido!";
		} else {
			return this.telefones.get(position);
		}
		 
	}
	
	
// getter e setter
	
	public ArrayList<String> getTelefones() {
		return this.telefones;
	}
	
	public int tamLista() {
		return this.telefones.size();
	}
	
	public void setTelefones(ArrayList<String> telefones) {
		this.telefones = telefones;
	}
	
	public Contato getContato_id() {
		return this.contato_id;
	}
	
	public void setContato_id(Contato contato_id) {
		this.contato_id = contato_id;
	}
	
	
	
	
}
