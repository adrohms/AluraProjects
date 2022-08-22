<%@page import="gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Todas as empresas até o momento:</p>
	<ul> 
		<%
			List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");

			for(Empresa empresa : empresas) {
		%>
			<li><%= empresa.getNome() %></li>

		<%
			}
		%>
	</ul>
</body>
</html>