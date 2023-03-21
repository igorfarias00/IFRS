<%@page import="br.com.nivelamento.DTO.Contato"%>
<%@page import="br.com.nivelamento.DAO.ContatoDao"%>
<%@page import="java.util.ArrayList;" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listando Contatos</title>
	</head>
	<body>
		<%
			try {
				ContatoDao contDao = new ContatoDao();
				ArrayList<Contato> contatos = contDao.listar();
				
				for(int i = 0; i < contatos.size(); i++){
					out.print("nome: " + contatos.get(i).getNome() + "<br>");
					out.print("email: " + contatos.get(i).getEmail() + "<br>");
				}
				
			} catch(Exception e){
				
			}
		%>
	</body>
</html>