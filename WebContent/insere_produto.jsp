<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 style="text-align:center">Inserir Produtos</h1>
	<form name="form1" method="get" action="ControladorProduto">
	<input type="hidden" name="instrucao" value="insereBBDD">
		<table width="50%" border="0">
			<tr>
				<td width="27%">Código Artigo</td>
				<td width="73%"><label for="icodigo"></label>
					<input type="text" name="icodigo" id="icodigo"/></td>
			</tr>
			<tr>
				<td width="27%">Descrição</td>
				<td width="73%"><label for="cdescricao"></label>
					<input type="text" name="cdescricao" id="cdescricao"/></td>
			</tr>
			<tr>
				<td width="27%">Preço</td>
				<td width="73%"><label for="dpreco"></label>
					<input type="text" name="dpreco" id="dpreco"/></td>
			</tr>
			<tr>
				<td width="27%">Quantidade</td>
				<td width="73%"><label for="iquantidade"></label>
					<input type="text" name="iquantidade" id="iquantidade"/></td>
			</tr>
			<tr>
				<td width="27%">Fabricante</td>
				<td width="73%"><label for="ifabcodigo"></label>
					<input type="text" name="ifabcodigo" id="ifabcodigo"/></td>
			</tr>

			<tr>
				<td></td>
				<td>
					<input type="submit" name="envio" id="envio" value="Enviar"/>
					<input type="reset" name="apago" id="apago" value="Excluir"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>