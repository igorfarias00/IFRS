/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifrs.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAMSUNG
 */
public class Cliente {
    private String cpf;
    private String nome;
    private String telefone;
    private String endereco;

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

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
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
    
    public void inserir() {
        try {
            /* Aqui vai o algoritmo de persistência */
            // Abrir uma conexão com o database;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tabajara", "root", "12345678");

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement("insert into clientes (cpf, nome, telefone, endereco) values (?, ?, ?, ?)");

            // Parametrizar a senteça SQL;
            ps.setString(1, this.cpf);
            ps.setString(2, this.nome);
            ps.setString(3, this.telefone);
            ps.setString(4, this.endereco);

            // Executar a Senteça;
            ps.execute();
            
            // Limpar a memória
            ps.close();
            con.close();
        } catch (Exception e) {
            ;
        }
    }
 
    public Cliente[] consultar() {
        List<Cliente> lista = new ArrayList();
        
        try {
            /* Aqui vai o algoritmo de persistência */
            // Abrir uma conexão com o database;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tabajara", "root", "12345678");

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement("select * from clientes");
            
            // Parametrizar a senteça SQL;
            
            // Executar a Senteça;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setCpf(rs.getString("cpf"));
                c.setNome(rs.getString("nome"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                
                lista.add(c);
            }
            
            // Limpar a memória
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            ;
        } 
        
        return lista.toArray(new Cliente[0]);
    }
    
    public void atualizar() {
        
    }
    
    public void excluir() {
        
    }
    
    
}
