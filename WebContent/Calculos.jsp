<%@page import="br.com.agabsistemas.CalculosMatematicos.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Chamando Metodo Soma </h1>
A soma de 7 e 5 = <%= Calculos.metodoSoma(5,7)
%>
<br>
<h1>Chamando Metodo Subtrai</h1>
A subtração de 7 - 5 = <%= Calculos.metodoResta(5,7)
%>
<br>
<h1>Chamando Metodo Multiplica</h1>
A multiplicação de 5 x 7 = <%= Calculos.metodoMultiplica(5,7)
%>


</body>
</html>