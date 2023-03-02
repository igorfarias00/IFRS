<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="br.com.igorfarias00.dao.*, br.com.igorfarias00.lojaVirtual.*, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <link href="CssHallowen.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/x-icon" href="imagens/favicon/favicon.ico">
        <title> Edição Usuário </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    </head> 
    <body>
    	
    	<%
    		String cpf = request.getParameter("cpf");
    		Usuario usuario = UsuarioDao.getUsuarioByCpf(cpf);
    	%>
    	
        <div id="corpo">
            <header>
                <div class="banner">
                    <figure >
                        <img src="imagens/banner.png" >
                        <figcaption></figcaption>
                    </figure>
                </div>
                <div class="menuLateral">
                    <nav id="navMenu">
                        <menu id="menu">
                           <li> <a href="index.html"><img src="imagens/skull.png"> Pagina inicial </a></li>
                           <li><a href="pesquisa.html"><img src="imagens/pumpkin-smile.png"> Fantasias Engraçadas </a></li>
                           <li><a href="form.html"><img src="imagens/ghost.png"> Competição de Fantasias </a></li>
                           <li><a href="clientes.jsp"><img src="imagens/frank.png">Clientes </a></li>
                           <li><a href="usuarios.jsp"><img src="imagens/vlad.png">Usuários </a></li>
                           <li><a href="produtos.jsp"><img src="imagens/spider.png"> Produtos </a></li>
                           <li><a href="pedidos.jsp"><img src="imagens/pedido.png"> Pedidos </a></li>
                        </menu>
                    </nav>
                </div>
            </header>        


            <div id="quadroCentral">
               <h1>Editando usuário</h1>
               <form action="editusuario.jsp" method="post">
               		
               		<input type="hidden" name="cpf" value="<%=usuario.getCpf() %>"/>
               		<table>
               			<tr>
               				<td>Nome:</td>
               				<td><input type="text" name="nome" value="<%=usuario.getNome() %>"/></td>
               			</tr>
               			<tr>
               				<td>Data de Nascimento:</td>
               				<td><input type="text" name="data_nascimento" value="<%=usuario.getData_nascimento() %>"/></td>
               			</tr>
               			<tr>
               				<td>email:</td>
               				<td><input type="email" name="email" value="<%=usuario.getEmail() %>"/></td>
               			</tr>
               			<tr>
               				<td>Whats:</td>
               				<td><input type="radio" name="whats" value="true"/>Sim
               					<input type="radio" name="whats" value="false"/>Não
               				</td>
               			</tr>
               			<tr>
               				<td>Telefone:</td>
               				<td><input type="text" name="telefone" value="<%=usuario.getTelefone() %>"/></td>
               			</tr>
               			<tr>
               				<td>Username:</td>
               				<td><input type="text" name="username" value="<%=usuario.getUsername() %>"/></td>
               			</tr>
               			<tr>
               				<td>Senha:</td>
               				<td><input type="password" name="senha" value="<%=usuario.getSenha() %>"/></td>
               			</tr>
               			
               			<tr>
               				<td><input type="submit" value="Salvar Edição" id="editar"></td>
               			</tr>
               				
               		</table>
               </form>
            </div>   
        </div> 
    </body>
</html>