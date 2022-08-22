<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>Nova empresa:</h3>
	<form action="${linkServletNovaEmpresa }" method="post">
		Nome: <input type="text" name="nome" /> <br> 
		Data: <input type="text" name="dataCadastro" /> <br>
		<input type="submit" /> <br>
		<a href="/gerenciador/listarEmpresas">Listar empresas</a>
	</form>
</body>
</html>