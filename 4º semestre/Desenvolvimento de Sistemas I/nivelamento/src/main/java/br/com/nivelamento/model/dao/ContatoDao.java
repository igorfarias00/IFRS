package br.com.nivelamento.model.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import br.com.nivelamento.model.entity.*;


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
	
	
	public static int salvarContato(Contato contato) {
		int status = 0;
		
		try {
			Connection conexao = getConnection();
			PreparedStatement query = conexao.prepareStatement("INSERT INTO contato (nome, email) values (?, ?)");
			
		
			query.setString(1, contato.getNome());
			query.setString(2, contato.getEmail());
			//query.setString(3, contato.getListaTelefone().getTelefones());
			
			status = query.executeUpdate();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
}
