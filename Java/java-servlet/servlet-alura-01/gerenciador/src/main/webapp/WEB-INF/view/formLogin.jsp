<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/theOneServlet?acao=LoginAcao" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h3>Login</h3>
	<form action="${linkServletNovaEmpresa }" method="post">
		Login: <input type="text" name="login" /> <br> 
		Senha: <input type="password" name="senha" /> <br>
		<input type="submit" /> <br>
	</form>
</body>
</html>