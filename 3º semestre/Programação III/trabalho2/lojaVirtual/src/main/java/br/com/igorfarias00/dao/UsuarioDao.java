package br.com.igorfarias00.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.igorfarias00.lojaVirtual.Usuario;

public class UsuarioDao {
	
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
	
	
	public static int salvarUsuario(Usuario u) {
		int status = 0;
		
		try {
			Connection conexao = getConnection();
			PreparedStatement query = conexao.prepareStatement("INSERT INTO usuarios (cpf, nome, email, telefone, username, senha ) values (?, ?, ?, ?, ?,?)");
			
		
			query.setString(1, u.getCpf());
			query.setString(2, u.getNome());
			//query.setDate(3, sqlDate);
			query.setString(3, u.getEmail());
			query.setString(4, u.getTelefone());
			query.setString(5, u.getUsername());
			query.setString(6, u.getSenha());
			
			status = query.executeUpdate();
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	
	public static int updateUsuario(Usuario u) {
		int status = 0;
		
		try {
			Connection conexao = getConnection();
			PreparedStatement query = (PreparedStatement) conexao.prepareStatement("Update usuarios SET nome=?, "
											+ "data_nascimento=?, email=?, telefone=?, username=?, senha=? WHERE cpf=?");
			 query.setString(1, u.getNome());
			 query.setString(2, u.getData_nascimento());
			 query.setString(3, u.getEmail());
			 query.setString(4, u.getTelefone());
			 query.setString(5, u.getUsername());
			 query.setString(6, u.getSenha());
			 query.setString(7, u.getCpf());
			 
			 status =  query.executeUpdate();
			 
			 System.out.println("ATUALIZADAÇO!");
			 System.out.println(status);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	public static Usuario getUsuarioByCpf(String cpf)  {
		
		Usuario usuario = null;
		
		try {
			Connection conexao = getConnection();
			PreparedStatement query = conexao.prepareStatement("SELECT * FROM usuarios where cpf = ?" );
			query.setString(1, cpf);
			
			ResultSet resultadoQuery = query.executeQuery();
			
			while(resultadoQuery.next()) {
				usuario = new Usuario();
				usuario.setNome(resultadoQuery.getString("nome"));
				usuario.setData_nascimento(resultadoQuery.getString("data_nascimento"));
				usuario.setEmail(resultadoQuery.getString("email"));
				usuario.setWhats(resultadoQuery.getBoolean("whats"));
				usuario.setTelefone(resultadoQuery.getString("telefone"));
				usuario.setUsername(resultadoQuery.getString("username"));
				usuario.setSenha(resultadoQuery.getString("senha"));
				
				
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return usuario;
	}
	
	public static List<Usuario> getAllUsuarios(){
		List<Usuario> list = new ArrayList<Usuario>();
		Usuario usuario = null;
		try {
			Connection conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement ("SELECT * FROM usuarios");
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {	
				usuario = new Usuario();
				usuario.setCpf(resultado.getString("cpf"));			
				usuario.setNome(resultado.getString("nome"));
				usuario.setData_nascimento(resultado.getString("data_nascimento"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setWhats(resultado.getBoolean("whats"));
				usuario.setTelefone(resultado.getString("telefone"));
				usuario.setUsername(resultado.getString("username"));
				usuario.setSenha(resultado.getString("senha"));
				
				list.add(usuario);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
		
	}
	
}
