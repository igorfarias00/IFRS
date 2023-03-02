<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="br.com.igorfarias00.dao.*, br.com.igorfarias00.lojaVirtual.*, java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <link href="CssHallowen.css" rel="stylesheet" type="text/css"/>
        <link rel="icon" type="image/x-icon" href="imagens/favicon/favicon.ico">
        <title> Adicionando Usuário </title>
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
               
				<jsp:include page="usuarioform.html"></jsp:include>
				
				
            </div>   
        </div> 
    </body>
</html>