<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Standard Taglib</title>
</head>
<body>
	
<%-- 	<c:if test="${not empty novaEmpresa}">
		<p> ${novaEmpresa} Cadastrada! </p>
	</c:if> --%>
		
	<h3>Lista de empresas:</h3>
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataCadastro}" pattern="dd/MM/yy"/>
			<a href="/gerenciador/removeEmpresa?id=${empresa.id}">remover</a> / 
			<a href="/gerenciador/editarEmpresa?id=${empresa.id}">editar</a></li>
			
		</c:forEach>
	</ul>
	<a href="/gerenciador/formNovaEmpresa.jsp">Adicionar nova empresa</a></li>
</body>
</html>