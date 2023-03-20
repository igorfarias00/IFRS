package br.com.nivelamento.model.entity;


public class Contato {
	private int id;
	private String nome;
	private String email;
	private Telefone listaTelefone;
	
	public Contato(int id, String nome, String email, Telefone lista) {
		this.setId(id);
		this.setNome(nome);
		this.setEmail(email);
		this.setListaTelefone(lista);
		
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Telefone getListaTelefone() {
		return listaTelefone;
	}
	public void setListaTelefone(Telefone listaTelefone) {
		this.listaTelefone = listaTelefone;
	}
	
	
	
	
}
