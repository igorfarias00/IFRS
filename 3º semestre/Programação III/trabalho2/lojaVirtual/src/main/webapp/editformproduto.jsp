<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="br.com.igorfarias00.dao.*, br.com.igorfarias00.lojaVirtual.*, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
        <link href="CssHallowen.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/x-icon" href="imagens/favicon/favicon.ico">
        <title> Edição Usuário </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
</head>
<body>
    	<%
    		int produto_id = Integer.parseInt(request.getParameter("produto_id"));
    		Produto produto = ProdutoDao.getProdutoById(produto_id);
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
               <h1>Editando Produto</h1>
               <form action="editproduto.jsp" method="post">
               		
               		<input type="hidden" name="produto_id" value="<%=produto.getProduto_id() %>"/>
               		<table>
               			<tr>
               				<td>Nome:</td>
               				<td><input type="text" name="nome" value="<%=produto.getNome() %>"/></td>
               			</tr>
               			<tr>
               				<td>Descricao:</td>
               				<td><input type="text" name="descricao" value="<%=produto.getDescricao() %>"/></td>
               			</tr>
               			<tr>
               				<td>Unidade:</td>
               				<td><input type="text" name="unidae" value="<%=produto.getUnidade() %>"/></td>
               			</tr>

               			<tr>
               				<td>Preço:</td>
               				<td><input type="text" name="preco" value="<%=produto.getPreco_unitario() %>"/></td>
               			</tr>

               				
               		</table>
               </form>
            </div>   
        </div> 
</body>
</html>