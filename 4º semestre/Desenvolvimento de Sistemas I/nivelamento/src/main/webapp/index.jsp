<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="br.com.nivelamento.DTO.Telefone"%>
<%@page import="br.com.nivelamento.DAO.ContatoDao"%>
<%@page import="java.util.ArrayList;" %>
<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta charset="UTF-8">
		<title> Cadastro Telefone</title>
		<link href="style.css" rel="stylesheet" type="text/css">
	</head>
	<body>
		<div id="central">
			<form action="inserirContato.jsp" method="POST">
			
				<label for="nomeId"> Nome: </label>
				<input type="text" id="nomeID" name="nome">
				
				<br>
				<label for="emailId"> Email: </label>
				<input type="email" id="emailId" name="email">
				
				
				
				<div id="listaTelUsuario">
					<%
						//Telefone listaRecebida = (Telefone)request.getAttribute("telefone");
					    //ArrayList<String> lista	= listaRecebida.getTelefones();
						
						//if(listaRecebida.tamLista() > 0){
						//	for(int i = 0; i < listaRecebida.tamLista(); i++){
						//		out.print(lista.get(i) + "<br/>");
						//	}
						//}
					%>							
				</div>

				
				<br>
				<label for="telId"> Telefone: </label>
				<input type="tel" id="telId" name="telefone">
				<button value="adicionarTel" action="ListaDeTelefones"> Adicionar</button>
				
				
				<br>
				<button type="submit"> Adicionar contato</button>
			</form>	
			
			<button onclick="listarContatos.jsp"> Lista de Contatos</button>
		</div>
	</body>
</html>