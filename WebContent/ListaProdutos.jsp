<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import = "java.util.*, br.com.agabsistemas.produtos.*"%>    
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<%
// obtem os produtos pelo controlador servlet
List<Produtos> osProdutos=(List<Produtos>) request.getAttribute("LISTAPRODUTOS");


%>

<body>

<%= osProdutos


%>

</body>
</html>