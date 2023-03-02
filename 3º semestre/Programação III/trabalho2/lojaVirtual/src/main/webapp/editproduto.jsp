<%@ page import="br.com.igorfarias00.dao.ProdutoDao"%>
<jsp:useBean id="u" class="br.com.igorfarias00.lojaVirtual.Produto"></jsp:useBean>

<jsp:setProperty property="*" name="u"/>
<%
	int i = ProdutoDao.updateProduto(u);
	response.sendRedirect("produtos.jsp");
%>
