/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrimeiroProjetoBanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author SAMSUNG
 */
public class Aluno {
    
    private int ra;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String rg;
    private String cpf;
    

    /**
     * @return the ra
     */
    public int getRa() {
        return ra;
    }

    /**
     * @param ra the ra to set
     */
    public void setRa(int ra) throws Exception {
        if (ra <= 0) {
            throw new Exception ("Matrícula deve ser um valor maior que 0!!!");
        }
        this.ra = ra;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) throws Exception {
        if (nome.length() < 5) {
            throw new Exception ("O nome deve ter no mínimo 5 caracteres!!!");
        }
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void inserir () throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercicio05", "root", "12345678");

            pstmt = con.prepareStatement("insert into aluno (ra, nome, endereco, telefone, email, rg, cpf) value (?, ?, ?, ?, ?, ?, ?)");
            pstmt.setInt(1, this.ra);
            pstmt.setString(2, this.nome);
            pstmt.setString(3, this.endereco);
            pstmt.setString(4, this.telefone);
            pstmt.setString(5, this.email);
            pstmt.setString(6, this.rg);
            pstmt.setString(7, this.cpf);
            
            pstmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }
    
    public void atualizar() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercicio05", "root", "12345678");

            pstmt = con.prepareStatement("update aluno set nome = ?, endereco = ?, telefone = ?, email = ?, rg = ?, cpf = ? where ra = ?");
            pstmt.setString(1, this.nome);
            pstmt.setString(2, this.endereco);
            pstmt.setString(3, this.telefone);
            pstmt.setString(4, this.email);
            pstmt.setString(5, this.rg);
            pstmt.setString(6, this.cpf);
            pstmt.setInt(7, this.ra);
            
            pstmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }
    
    public void excluir() throws Exception {
        Connection con = null;
        PreparedStatement pstmt = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercicio05", "root", "12345678");

            pstmt = con.prepareStatement("delete from aluno where ra = ?");
            pstmt.setInt(1, this.ra);
            
            pstmt.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }
    
    public void consultar() throws Exception{
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/exercicio05", "root", "12345678");

            pstmt = con.prepareStatement("select * from aluno");
            
            rs = pstmt.executeQuery();
            while (rs.next()) {
                System.out.print("Matrícula: "+rs.getInt("ra")+" - ");
                System.out.println("Nome: "+rs.getString("nome"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        }
    }
    
}
