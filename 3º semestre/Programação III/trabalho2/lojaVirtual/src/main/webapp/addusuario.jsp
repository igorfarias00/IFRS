<%@ page import="br.com.igorfarias00.dao.UsuarioDao"%>
<jsp:useBean id="u" class="br.com.igorfarias00.lojaVirtual.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>
<% 
	int i = UsuarioDao.salvarUsuario(u);

	if(i > 0 ){
		response.sendRedirect("addusuario-success.jsp");
	} else {
		response.sendRedirect("addusuario-fail.jsp");
	}
%>