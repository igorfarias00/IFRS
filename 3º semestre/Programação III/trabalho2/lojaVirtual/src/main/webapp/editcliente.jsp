<%@ page import="br.com.igorfarias00.dao.ClientesDao"%>
<jsp:useBean id="c" class="br.com.igorfarias00.lojaVirtual.Cliente"></jsp:useBean>

<jsp:setProperty property="*" name="c"/>
<%
	int i = ClientesDao.updateCliente(c);
	response.sendRedirect("clientes.jsp");
%>
