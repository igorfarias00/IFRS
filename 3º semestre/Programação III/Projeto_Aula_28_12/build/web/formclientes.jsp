<%-- 
    Document   : formclientes
    Created on : 21 de dez. de 2022, 21:35:55
    Author     : SAMSUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Clientes</h1>
        <hr>
        <form action="ClienteServlet" method="post">
            
            <label for="cpf">CPF:</label><br>
            <input type="text" name="cpf" id="cpf" size="15"><br><br>

            <label for="nome">Nome:</label><br>
            <input type="text" name="nome" id="nome" size="30"><br><br>

            <label for="telefone">Telefone:</label><br>
            <input type="text" name="telefone" id="telefone" size="20"><br><br>

            <label for="endereco">Endereço:</label><br>
            <textarea name="endereco" id="endereco" cols="100" rows="3"></textarea><br><br>

            <input type="submit" name="salvar" value="Salvar Cliente">
            <input type="reset" name="limpar" value="Limpar">
        </form>

    </body>
</html>
