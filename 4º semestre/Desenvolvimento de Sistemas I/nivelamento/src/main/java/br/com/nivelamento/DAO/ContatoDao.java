package br.com.nivelamento.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.nivelamento.DTO.*;


public class ContatoDao {
	
	public static Connection getConnection() {
		Connection conexao = null; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/nivelamento", "root", "1930");			
			
		} catch (Exception e ) {
			System.out.println(e);
		}
		return conexao;
	}
	
	
	public void salvarContato(Contato contato) {
		
		try {
			Connection conexao = getConnection();
			PreparedStatement insert = conexao.prepareStatement("INSERT INTO contato (nome, email) values (?, ?)");
			
		
			insert.setString(1, contato.getNome());
			insert.setString(2, contato.getEmail());
			//query.setString(3, contato.getListaTelefone().getTelefones());
			
			insert.execute();
			insert.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	public ArrayList<Contato> listar() {
		ArrayList<Contato> contatos = null;
		String nome;
		String email;
		
		try {
			Connection conexao = getConnection();
			PreparedStatement query = conexao.prepareStatement("SELECT * FROM contato");
			ResultSet retorno;
			
			retorno = query.executeQuery();
			
			while(retorno.next()) {
				nome = retorno.getString("nome");
				email = retorno.getString("email");
				// retorno da chave estrangeira para os telefones 
				contatos.add(new Contato(nome, email, null));
				
			}
			
			
		} catch(Exception e) {
			
		}
		
		return contatos;
	}
	
}
