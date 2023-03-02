<%@ page import="br.com.igorfarias00.dao.UsuarioDao"%>
<jsp:useBean id="u" class="br.com.igorfarias00.lojaVirtual.Usuario"></jsp:useBean>

<jsp:setProperty property="*" name="u"/>
<%
	int i = UsuarioDao.updateUsuario(u);
	response.sendRedirect("usuarios.jsp");
%>
