<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					
				</div>
				
				<br>
				<label for="telId"> Telefone: </label>
				<input type="tel" id="telId">
				<button value="adicionarTel"> Adicionar</button>
				
				<br>
				<button type="submit"> Adicionar contato</button>
			</form>	
			
			<button action="listarContatos.jsp"> Lista de Contatos</button>
		</div>
	</body>
</html>