<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
 
 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

.cabecalho{
	font-size:1.2em;
	font-weight:bold;
	color:#FFFFFF;
	background-color:#08088A;

}

.filas{

	text-align:center;
	background-color: #5882FA; 
}

.divide{
	font-size:.40em;
	color:#00ff00;


}

table{
	float:left;

}

#conteinerBotao{
	margin-left:600px;


}

</style>


</head>

<body>
<table >
	<div>
	  <div class="divide">
	  </div>
	  <div class="divide">
		<tr>
  			<td class="cabecalho">Codigo</td>
			<td class="cabecalho">Descrição</td>
			<td class="cabecalho">Preço</td>
			<td class="cabecalho">Quantidade</td>
			<td class="cabecalho">Fabricante</td>
			<td class="cabecalho">Opções</td>
			
		</tr>
		
		<c:forEach var="prod" items="${LISTAPRODUTOS}">
		
			<!-- link para alterar produto com campo chave -->
			<c:url var="linkAltera" value="ControladorProduto">
				
				<c:param name="instrucao" value="carregar"></c:param>
				<c:param name="CProduto" value="${prod.codigo}"></c:param>
				
			</c:url>
			<!-- link para excluir produto com campo chave -->
			<c:url var="linkExclui" value="ControladorProduto">
				
				<c:param name="instrucao" value="excluir"></c:param>
				<c:param name="CProduto" value="${prod.codigo}"></c:param>
				
			</c:url>
			<tr>
				<td class="filas">${prod.codigo}</td>
				<td class="filas">${prod.descricao}</td>
				<td class="filas">${prod.preco}</td>
				<td class="filas">${prod.quantidade}</td>
				<td class="filas">${prod.fabricante_codigo}</td>
				<td class="filas"><a href="${linkAltera}">Altera</a>&nbsp;&nbsp;
								  <a href="${linkExclui}">Exclui</a></td>
				
			</tr>
			
		</c:forEach> 	
		</div>	
		<div class="divide">
			
	  	</div>
	</div>
</table>
<div id="conteinerBotao">
   <input type="button" value="Inserir Registro" onclick="window.location.href='insere_produto.jsp'"/>

</div>
</body>
</html>