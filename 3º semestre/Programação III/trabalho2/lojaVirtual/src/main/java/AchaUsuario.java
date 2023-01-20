
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class AchaUsuario
 */
public class AchaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AchaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conexao = null;
		PreparedStatement p = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql//localhost:3306/lojaVirtual"); //user e senha // colocar depois
			
			p = conexao.prepareStatement("SELECT cpf, nome, data_nascimento, email, telefone FROM usuarios WHERE nome like '?%'");
			p.setString(0, request.getParameter("filtrar"));
			
			p.execute();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conexao = null;
		PreparedStatement p = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql//localhost:3306/lojaVirtual");  // user e senha
			
			p = conexao.prepareStatement("INSERT INTO usuarios (cpf, nome, data_nascimento, email, telefone,whats,username, senha) values (?,?,?,?,?,?,?,?)");
			p.setString(1, request.getParameter("cpf"));
			p.setString(2, request.getParameter("nome"));
			p.setString(3, request.getParameter("data_nascimento"));
			p.setString(4, request.getParameter("email"));
			p.setString(5, request.getParameter("telefone"));
			p.setInt(6, Integer.parseInt(request.getParameter("whats")));
			p.setString(7, request.getParameter("username"));
			p.setString(8, request.getParameter("senha"));
			
			p.execute();
			
			System.out.println("Cadastro do usuario realizado");
			
		} catch (Exception e) {
			System.out.println(e);
			
		} finally {
			try {
				p.close();
				conexao.close();
			} catch (Exception e){
				System.out.println(e);
			}
		}
		
		doGet(request, response);
	}

}
