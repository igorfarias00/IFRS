<%@page import="br.com.nivelamento.DTO.Contato"%>
<%@page import="br.com.nivelamento.DAO.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title> Inserindo contato... </title>
	</head>
	<body>
		<%	
			try{
				Contato contato = new Contato(request.getParameter("nome"), request.getParameter("email"), null);
		
				ContatoDao contDAO = new ContatoDao();
				contDAO.salvarContato(contato);
			} catch (Exception e){
				
				
			}
				
		%>
	</body>
</html>