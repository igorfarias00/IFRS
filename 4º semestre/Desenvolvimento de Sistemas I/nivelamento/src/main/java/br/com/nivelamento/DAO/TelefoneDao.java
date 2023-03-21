package br.com.nivelamento.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import br.com.nivelamento.DTO.*;


public class TelefoneDao {
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
	
	
	public void salvarTelefone(Contato contato, ArrayList<String> telefone) {
		
		try {
			Connection conexao = getConnection();
			PreparedStatement insert = conexao.prepareStatement("INSERT INTO telefone (id, telefone) values (?, ?)");
			//adicionar na estrutura da tabela telefone, utilizando o id do contato para chave estrangeira( requisistar do objeto)
		
			contato.getId();
			
			insert.execute();
			insert.close();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
}
