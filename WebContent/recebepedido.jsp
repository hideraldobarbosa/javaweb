<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	// lendo dados do formulario
	String cidadefavorita=request.getParameter("cidadefavorita");
	// cria o cookie
	Cookie oCookie = new Cookie("agenciaviagem.cidadefavorita",cidadefavorita);
	// vida de um cookie
	oCookie.setMaxAge(365*24*60*60);
	// Enviar ao usuario
	response.addCookie(oCookie);

%>
Obrigado por enviar sua preferencia

<a href="agenciaviagem.jsp">Ir a agencia de viagem</a>




</body>
</html>