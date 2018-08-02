<%@page import="java.sql.Statement"%>
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
String nome= request.getParameter("nome");

String sobrenome= request.getParameter("sobrenome");

String pais = request.getParameter("pais");

String usuario = request.getParameter("usuario");

String senha = request.getParameter("senha");

String area = request.getParameter("area");

Class.forName("com.mysql.jdbc.Driver");

java.sql.Connection minhaConexao = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3308/drogaria","root","1234");

java.sql.Statement meuStatement = minhaConexao.createStatement();

String instrucaoSql = "insert into tabusuario (nome, sobrenome, usuario, senha, pais, area) values ('"+nome+"','"+sobrenome+"','"+usuario+"','"+senha+"','"+pais+"','"+area+"')";

out.println("instrução :"+instrucaoSql);

meuStatement.executeUpdate(instrucaoSql);

out.println("Registrado com sucesso.");
%>


</body>
</html>