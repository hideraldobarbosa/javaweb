<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%

 	String alunos[]={"Antonio", "Sandra","Ana Clara", "Maria"};
	pageContext.setAttribute("osAlunos", alunos);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<br/>
<h1>Em codigo Tags Java</h1>

	<c:forEach var="tempAlunos" items="${osAlunos}">
		${tempAlunos} <br/>	
	
	</c:forEach>



</body>
</html>