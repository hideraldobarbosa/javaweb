<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Exemplos de Objetos predefinidos JSP </h1>

Requisição de dados de Navegador : <%= request.getHeader("User-Agent") %>
<br><br>
Requisição de Idioma Utilizado : <%=request.getLocale() %>


</body>
</html>