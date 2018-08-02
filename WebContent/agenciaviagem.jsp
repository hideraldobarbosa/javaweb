<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center">Agência de Viagem</h1>
<%
	//valor por defeito
	String cidadefavorita = "Madrid";

	// le o cookie do pedido de navegador
	Cookie[] osCookies=request.getCookies();
	
	// buscar as preferencias - a cidade favorita
	if(osCookies!=null){
	 	for (Cookie cookietemporario: osCookies){
			if("agenciaviagem.cidadefavorita".equals(cookietemporario.getName())){
					cidadefavorita=cookietemporario.getValue();
				break;
			}
	 	}
	}

%>
<h3> Voos para <%= cidadefavorita %></h3>
<p>este é  um texto exemplo</p>
<p>este é  um texto exemplo</p>
<p>este é  um texto exemplo</p>


<h3> Hotels de <%= cidadefavorita %></h3>
<p>este é  um texto exemplo</p>
<p>este é  um texto exemplo</p>
<p>este é  um texto exemplo</p>

<h3> Restaurantes de <%= cidadefavorita %></h3>
<p>este é  um texto exemplo</p>
<p>este é  um texto exemplo</p>
<p>este é  um texto exemplo</p>


</body>
</html>