<%-- 
    Document   : listaclientes
    Created on : 28 de dez. de 2022, 19:30:03
    Author     : SAMSUNG
--%>

<%@page import="br.edu.ifrs.modelo.Cliente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Clientes</h1>
        <hr>
        <p><a href="formclientes.jsp">Inserir um novo Cliente</a></p>
        <table border="1">
            <tr>
                <th>CPF</th>
                <th>Nome</th>
                <th>Telefone</th>
                <th>Endereço</th>
            </tr>
            <%
                Cliente clientes[] = (Cliente[])request.getAttribute
                                     ("lista_de_clientes");
                for (int i=0; i<clientes.length; i++) {
            %>
                    <tr>
                        <td><%= clientes[i].getCpf()%></td>
                        <td><%= clientes[i].getNome()%></td>
                        <td><%= clientes[i].getTelefone()%></td>
                        <td><%= clientes[i].getEndereco()%></td>
                    </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
