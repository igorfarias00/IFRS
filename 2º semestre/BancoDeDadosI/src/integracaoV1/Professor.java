package integracaoV1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Professor {
	int id;
	String nome;
	int matricula;
	int numero;
	String complemento;
	double salario;
	String nivel_formacao;
	int Telefone_id;
	int	Endereco_id;
	boolean coordenador;
	
	
	public Professor() {
		
	}
	
	
	void inserir() throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diariodeclasse", "root", "1930"); // atualizar com o nome do banco de dados que sera utilizado
			
			pstmt = con.prepareStatement("insert into professor (id, nome, "
										+ "matricula, "
										+ "numero, "
										+ "complemento, "
										+ "salario, "
										+ "nivel_formacao, "
										+ "Telefone_id, "
										+ "Endereco_id, "
										+ "Coordenador) value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			
			pstmt.setInt(1, this.id);
			pstmt.setString(2, this.nome);
			pstmt.setInt(3, this.matricula);
			pstmt.setInt(4, this.numero);
			pstmt.setString(5, this.complemento);
			pstmt.setDouble(6, this.salario);
			pstmt.setString(7, this.nivel_formacao);
			pstmt.setInt(8, this.Telefone_id);
			pstmt.setInt(9, this.Endereco_id);
			pstmt.setBoolean(10, this.coordenador);
			
			pstmt.execute();
			
		} catch (SQLException ex) {
			//System.out.println("Nao foi");
			throw ex;
		} finally {
			if( pstmt != null) {
				pstmt.close();
				
			}
			
			if(con != null ) {
				con.close();
			}
			
			
			
		}
	}
	
	void excluir() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            //Class.forName("com.mysql.jdbc.Driver"); // console avisando de depreciação desse comando
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diariodeclasse", "root", "1930");

            pstmt = con.prepareStatement("delete from professor where id = ?");
            pstmt.setInt(1, this.id);
            
            pstmt.execute();
            
            
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
        
        
	}
	
	void consultar(int matricula) throws Exception {
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	        
	    try {
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diariodeclasse", "root", "1930");

	        pstmt = con.prepareStatement("select * from professor where matricula = ?");
	        pstmt.setInt(1, matricula);
	        
	        rs = pstmt.executeQuery();
	        while (rs.next()) {
	        	System.out.println("Nome: "+rs.getString("nome"));
	        	System.out.print("Matrícula: "+rs.getInt("matricula")+" - ");
	            System.out.println("Id: "+rs.getInt("id"));
	            this.id = rs.getInt("id");
	        }
	        
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        if (pstmt != null) pstmt.close();
	        if (con != null) con.close();
	    }
	}
	
	void atualizar() throws Exception{
		Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	        
	    try {
	    	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/diariodeclasse", "root", "1930");

	        pstmt = con.prepareStatement("UPDATE professor SET nome = ?, matricula = ?, numero = ?, complemento = ?, salario = ?, nivel_formacao = ?, Telefone_id = ?, Endereco_id= ? , Coordenador = ?  WHERE id = ? ");
	            
			pstmt.setString(1, this.nome);
			pstmt.setInt(2, this.matricula);
			pstmt.setInt(3, this.numero);
			pstmt.setString(4, this.complemento);
			pstmt.setDouble(5, this.salario);
			pstmt.setString(6, this.nivel_formacao);
			pstmt.setInt(7, this.Telefone_id);
			pstmt.setInt(8, this.Endereco_id);
			pstmt.setBoolean(9, this.coordenador);
			pstmt.setInt(10, this.id);
			
			pstmt.execute();
	        
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        if (pstmt != null) pstmt.close();
	        if (con != null) con.close();
	    }
	}
}
