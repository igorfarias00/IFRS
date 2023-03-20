<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="UTF-8">
	<title>Cadastro Telefone</title>
	<link href="style.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="central">
		<form>
		
			<label for="nomeId"> Nome: </label>
			<input type="text" id="nomeID">
			
			<br>
			<label for="emailId"> Email: </label>
			<input type="email" id="emailId">
			
			<div id="listaTelUsuario">
				
			</div>
			
			<br>
			<label for="telId"> Telefone: </label>
			<input type="tel" id="telId">
			<button value="adicionar"> Adicionar</button>
			
			<br>
			<button type="submit">Adicionar contato</button>
		</form>	
		
		<button action=""> Lista de Contatos</button>
	</div>
</body>
</html>