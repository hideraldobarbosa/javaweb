<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Validação de Usuários</title>
</head>
<body>
<%@ page import="java.sql.*" %>
<%

String usuario = request.getParameter("usuario");

String senha = request.getParameter("senha");

Class.forName("com.mysql.jdbc.Driver");

java.sql.Connection minhaConexao = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3308/drogaria","root","1234");

PreparedStatement Consultapreparada=minhaConexao.prepareStatement("Select * from tabusuario where usuario=? and senha=?");
Consultapreparada.setString(1,usuario);
Consultapreparada.setString(2,senha);
ResultSet meuResultado=Consultapreparada.executeQuery();

if (meuResultado.absolute(1)){
	out.println("Usuario Autorizado.");
	
}
else {
	out.println("Usuario não AUTORIZADO.");
}
%>

</body>
</html>