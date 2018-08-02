<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, java.sql.*, br.com.agabsistemas.jsptags.empregado" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% 
      ArrayList<empregado> dados = new ArrayList<>();
	  try{
		  Class.forName("com.mysql.jdbc.Driver");

		  java.sql.Connection minhaConexao = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3308/drogaria","root","1234");

		  java.sql.Statement meuStatement = minhaConexao.createStatement();
	  
     	  String instrucaoSql = "Select * from empregados";
		  ResultSet rs=meuStatement.executeQuery(instrucaoSql);
		  
		  while(rs.next()){
			  dados.add(new empregado(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
		  }
		  rs.close();
		  minhaConexao.close();
		  
	  }catch(Exception erro){
		  out.println("Houve um erro na leitura do registro.");
	  }
	  
	  pageContext.setAttribute("osEmpregados", dados);
	  
	  
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
	.cabecalho{
		font-weight:bold;
	}
</style>
</head>
<body>
<h1>Em codigo Tags Java</h1>

<table border="1">
<tr class="cabecalho">
<td>
nome
</td>
<td>
sobrenome
</td>
<td>
posto
</td>
<td>
salario
</td>

<td>
Bonus
</td>
</tr>

	<c:forEach var="EmpTemp" items="${osEmpregados}">
		<tr>
			<td>
				${EmpTemp.nome}
			</td>
			<td>
				${EmpTemp.sobrenome} 
			</td>
			<td>
				${EmpTemp.posto} 
			</td>
			<td>
				$(EmpTemp.salario)
			</td>
			<td>
				<c:if test="${EmpTemp.salario<40000 }">5000</c:if>
				<c:if test="${EmpTemp.salario>=40000 }">----</c:if>
				
			</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>