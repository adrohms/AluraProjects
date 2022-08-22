<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listagem</title>
</head>
<body>
	
<%-- 	<c:if test="${not empty novaEmpresa}">
		<p> ${novaEmpresa} Cadastrada! </p>
	</c:if> --%>
	<h3> Usuario: ${usuarioLogado.login} </h3><br>
	<p> <a href="/gerenciador/theOneServlet?acao=ChamarLogoutAcao">Logout</a> </p>
	<h3> Lista de empresas: </h3>
	<ul>
		<c:forEach items="${empresas}" var="empresa">
			<li>${empresa.nome} - <fmt:formatDate value="${empresa.dataCadastro}" pattern="dd/MM/yy"/>
			<a href="/gerenciador/theOneServlet?acao=RemoverEmpresaAcao&id=${empresa.id}">remover</a> / 
			<a href="/gerenciador/theOneServlet?acao=EditarEmpresaAcao&id=${empresa.id}">editar</a></li>
			
		</c:forEach>
	</ul>
	<a href="/gerenciador/theOneServlet?acao=ChamarCriacaoEmpresaAcao">Criar nova empresa</a>
</body>
</html>