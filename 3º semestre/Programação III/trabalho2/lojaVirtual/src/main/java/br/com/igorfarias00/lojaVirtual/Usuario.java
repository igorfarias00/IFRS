package br.com.igorfarias00.lojaVirtual;




public class Usuario {
	private String cpf;
	private String nome;
	private String data_nascimento;
	private String email;
	private String telefone;
	private boolean whats;
	private String Username;
	private String senha;

	
	public Usuario() {
		
		
    }
	
	
	
	
	
	
	// -------- getters e setters ---------------------------------
	
    public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isWhats() {
		return whats;
	}

	public void setWhats(boolean whats) {
		this.whats = whats;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}






	public String getTelefone() {
		return telefone;
	}






	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}





}
