<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align:center">
	<h1>Exemplo de Declarações</>
	<%!
	     private int resultado;
		
		 public int metodoSoma(int num1, int num2){
			 resultado = num1+num2;
			 
			 return resultado;
		 }
	
		 public int metodoResta(int num1, int num2){
			 resultado = num1-num2;
			 
			 return resultado;
		 }

		 public int metodoMultiplica(int num1, int num2){
			 resultado = num1*num2;
			 
			 return resultado;
		 }

	
	%>
	
	Resultado do metodo soma é:<%=  metodoSoma(7,5) %>
<br>
    Resultado do metodo subtrai é:<%=  metodoResta(7,5) %>
<br>
	Resultado do metodo Multiplica é:<%=  metodoMultiplica(7,5) %>



</body>
</html>