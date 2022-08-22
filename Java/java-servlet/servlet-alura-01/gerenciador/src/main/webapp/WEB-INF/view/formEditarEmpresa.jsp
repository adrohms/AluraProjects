<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/theOneServlet?acao=AtualizarEmpresaAcao" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar</title>
</head>
<body>
	<h3>Editar empresa:</h3>
	<form action="${linkServletNovaEmpresa}" method="post">
		Nome: <input type="text" name="nome" value="${empresa.nome}"/> <br> 
		Data: <input type="text" name="dataCadastro" value="<fmt:formatDate value="${empresa.dataCadastro}" pattern="dd/MM/yy"/>" /> <br>
		<input type="text" name="id" value="${empresa.id}" hidden="true"/>
		<input type="submit" /> <br>
		<a href="/gerenciador/theOneServlet?acao=ListarEmpresasAcao">Listar empresas</a>
	</form>
</body>
</html>