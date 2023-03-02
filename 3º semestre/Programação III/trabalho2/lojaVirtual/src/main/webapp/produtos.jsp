<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.igorfarias00.dao.*, br.com.igorfarias00.lojaVirtual.*, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <link href="CssHallowen.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/x-icon" href="imagens/favicon/favicon.ico">
        <title> Halloween </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
   
    </head> 
    <body>
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
                <h1>Produtos</h1>
            	<hr><br>
                <form action="" method="get" onsubmit="">
                
                    <label for="pesquisa">Nome: </label><br>
                    <input id="pesquisa" name="filtrar" type="search">
                    <input id="btFiltrar"  type="submit">
                </form>
                <br>
                <form>
                    <a href="#"><input id="inserir" name="inserir" value="Inserir" type="button" >  </a>
                    
                    
                </form>
               	<%
					List<Produto> list = ProdutoDao.getAllClientes();
					request.setAttribute("list", list);				
				%>
				
				<table class="tabela">
					<tr class="cabecalho">
						<th> Seleção </th>
						<th> Id </th>
						<th> Nome</th>
						<th> Descrição</th>
						<th> Unidade</th>
						<th> Preço</th>
						<th> Atualizar</th>
						<th> Excluir</th>
						<c:forEach items="${list}" var="produto">
							<tr class="dados1">
								<td> <input type="checkbox" name="selecao"> </td>
								<td>${produto.getProduto_id()}</td>
								<td>${produto.getNome()}</td>
								<td>${produto.getDescricao()}</td>
								<td>${produto.getUnidade()}</td>
								<td>${produto.getPreco_unitario()}</td>								
								<td><a href="editformproduto.jsp?produto_id=${produto.getProduto_id() }"><input id="atualizar" name="atualizar" value="Atualizar" type="submit">  </a></td>
                    			<td><a href="#"><input id="excluir" name="Excluir" value="Excluir" type="reset"> </a></td>
							</tr>
						</c:forEach>
					</tr>
				</table>
               
            </div>   
            </div>   
        </div> 
    </body>