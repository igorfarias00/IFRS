package br.com.igorfarias00.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.igorfarias00.lojaVirtual.Cliente;
import br.com.igorfarias00.lojaVirtual.Usuario;

public class ClientesDao {
	
	public static Connection getConnection() {
		Connection conexao = null; 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/lojavirtual", "root", "1930");			
			
		} catch (Exception e ) {
			System.out.println(e);
		}
		return conexao;
	}
	
	public static int updateCliente(Cliente c) {
		int status = 0;
		
		try {
			Connection conexao = getConnection();
			PreparedStatement query = (PreparedStatement) conexao.prepareStatement("UPDATE clientes SET nome=?, "
											+ "data_nascimento=?, email=?, telefone=? WHERE cliente_id=?");
			 query.setString(1, c.getNome());
			 query.setDate(2, java.sql.Date.valueOf(c.getData_nascimento()));
			 query.setString(3, c.getEmail());
			 query.setString(4, c.getTelefone());
			 query.setString(5, c.getCpf());
			 
			 status =  query.executeUpdate();
			 
			 System.out.println("ATUALIZADAÇO!");
			 System.out.println(status);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
public static Cliente getClienteById(int id)  {
		
		Cliente cliente = null;
		
		try {
			Connection conexao = getConnection();
			PreparedStatement query = conexao.prepareStatement("SELECT * FROM clientes where cliente_id = ?" );
			query.setInt(1, id);
			
			ResultSet resultadoQuery = query.executeQuery();
			
			while(resultadoQuery.next()) {
				cliente = new Cliente();
				cliente.setNome(resultadoQuery.getString("nome"));
				cliente.setData_nascimento(resultadoQuery.getString("data_nascimento"));
				cliente.setEmail(resultadoQuery.getString("email"));
				cliente.setWhats(resultadoQuery.getBoolean("whats"));
				cliente.setTelefone(resultadoQuery.getString("telefone"));
				
				
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return cliente;
	}

	public static List<Cliente> getAllClientes(){
		List<Cliente> list = new ArrayList<Cliente>();
		Cliente cliente = null;
		try {
			Connection conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement ("SELECT * FROM clientes");
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {	
				cliente = new Cliente();
				cliente.setCliente_id(resultado.getString("cliente_id"));		
				cliente.setCpf(resultado.getString("cpf"));			
				cliente.setNome(resultado.getString("nome"));
				cliente.setData_nascimento(resultado.getString("data_nascimento"));
				cliente.setEmail(resultado.getString("email"));
				cliente.setWhats(resultado.getBoolean("whats"));
				cliente.setTelefone(resultado.getString("telefone"));
				
				
				list.add(cliente);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
		
	}
}
