<%-- 
    Document   : fatura
    Created on : 21 de dez. de 2022, 20:07:22
    Author     : SAMSUNG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exercício 06</title>
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div id="quadro">
            <div id="cabecalho">
                <img src="tabajara.jpg" align="left" width="150" style="padding-top: 10px; padding-left: 10px;">
                <h1 align="center">Fatura Online</h1>
            </div>
            <div id="corpo">
                <p style="color: #000000; font-weight: bold;">Dados do Cliente</p>
                <ul>
                    <li>CPF: <%= request.getParameter("cpf") %></li>
                    <li>Nome:  <%= request.getParameter("nome") %></li>
                    <li>Telefone:  <%= request.getParameter("telefone") %></li>
                    <li>Endereço:  <%= request.getParameter("endereco") %></li>
                </ul>

                <table border="1" cellpadding="5" cellspacing="0" style="border-color: #000000">
                    <caption style="color: #000000; font-weight: bold;">Dados do Serviço</caption>
                    <tr align="center">
                        <th>Descrição</th>
                        <th>Data de Realização</th>
                        <th>Tipo de Serviço</th>
                        <th>Tempo</th>
                        <th>Valor Unitário</th>
                    </tr>
                    <tr>
                        <%
                        %>
                        
                        <td> <%= request.getParameter("descricao_servico") %> </td>
                        <td> <%= request.getParameter("data_realizacao") %> </td>
                        <td> <%= request.getParameter("tipo") %> </td>
                        <td> <%= request.getParameter("tempo") %> </td>
                        <td>R$ <%= request.getParameter("valor_unitario") %></td>
                    </tr>
                </table>
            </div>
            <div id="rodape">
                <ul class="totais">
                    <li>Vencimento: <%= request.getParameter("data_vencimento") %></li>
                    <li>Total: R$  <%= request.getAttribute("valor_total") %></li>
                    <li>Valor do ICMS: R$  <%= request.getAttribute("valor_icms") %></li>
                </ul>
            </div>
	</div>
    </body>
</html>
