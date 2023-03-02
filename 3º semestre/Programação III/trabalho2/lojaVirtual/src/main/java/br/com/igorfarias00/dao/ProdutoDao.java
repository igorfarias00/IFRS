package br.com.igorfarias00.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import br.com.igorfarias00.lojaVirtual.Produto;

public class ProdutoDao {
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
	
	public static int updateProduto(Produto p) {
		int status = 0;
		
		try {
			Connection conexao = getConnection();
			PreparedStatement query = (PreparedStatement) conexao.prepareStatement("UPDATE produtos SET nome=?, "
											+ "descricao=?, unidade=?, preco_unitario=? WHERE produto_id=?");
			 query.setString(1, p.getNome());
			 query.setString(2, p.getDescricao());
			 query.setString(3, p.getUnidade());
			 query.setFloat(4, p.getPreco_unitario());
			 
			 status =  query.executeUpdate();
			 
			 System.out.println("ATUALIZADAÇO!");
			 System.out.println(status);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
public static Produto getProdutoById(int id)  {
		
		Produto produto = null;
		
		try {
			Connection conexao = getConnection();
			PreparedStatement query = conexao.prepareStatement("SELECT * FROM produtos where produto_id = ?" );
			query.setInt(1, id);
			
			ResultSet resultadoQuery = query.executeQuery();
			
			while(resultadoQuery.next()) {
				produto = new Produto();
				produto.setNome(resultadoQuery.getString("nome"));
				produto.setDescricao(resultadoQuery.getString("descricao"));
				produto.setUnidade(resultadoQuery.getString("Unidade"));
				produto.setPreco_unitario(resultadoQuery.getFloat("preco_unitario"));
				
				
			}
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return produto;
	}

	public static List<Produto> getAllClientes(){
		List<Produto> list = new ArrayList<Produto>();
		Produto produto = null;
		try {
			Connection conexao = getConnection();
			PreparedStatement ps = conexao.prepareStatement ("SELECT * FROM produtos");
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()) {	
				produto = new Produto();
				produto.setProduto_id(resultado.getInt("produto_id"));				
				produto.setNome(resultado.getString("nome"));
				produto.setDescricao(resultado.getString("descricao"));
				produto.setUnidade(resultado.getString("unidade"));
				produto.setPreco_unitario(resultado.getFloat("preco_unitario"));
				
				
				list.add(produto);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return list;
		
	}
}
