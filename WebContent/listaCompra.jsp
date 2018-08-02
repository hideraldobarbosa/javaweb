<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html>
  <head>
    <meta charset="utf-8">
    <title>Cadastro de Usuários</title>
    <link rel="stylesheet" type="text/css" href="estilos.css" />
  </head>
   
    <body>

      <h1 text-align:"Center">Carrinho de Compras</h1>
      <form name="FormularioCompra" action="listaCompra.jsp">
	    <p>
	       <tr>
	    	<label>
	    	   <input type="checkbox" name="artigos" value="agua" >Agua</label><br/>
	    	<label>
	    	   <input type="checkbox" name="artigos" value="leite" >Leite</label><br/>
	    	<label>
	    	   <input type="checkbox" name="artigos" value="pão" >Pão</label><br/>
	    	<label>
	    	   <input type="checkbox" name="artigos" value="maçã" >Maçã</label><br/>
	    	<label>
	    	   <input type="checkbox" name="artigos" value="carne">Carne<label><br/>
	    	<label>
	    	   <input type="checkbox" name="artigos" value="pescado" >Pescado</label><br/>
    	  </tr>
    	  <tr>
       	  <td colspan="2" align="center"><input type="submit" name="button" id="button" value="Enviar"/>
       	  </td>
       	  </tr>
       	  		
       </table>
        </form>
     <h2>Carro de Compras</h2>
     <ul>
<%     
    
List<String> ListaElementos = (List<String>) session.getAttribute("meusElementos");

if(ListaElementos==null){
	ListaElementos = new ArrayList<String>();
	session.setAttribute("meusElementos",ListaElementos);
	
}

String[] elementos=request.getParameterValues("artigos");

	if (elementos != null){
		for (String elemTemp : elementos){
			ListaElementos.add(elemTemp);
			
		}
	}

	for (String elemTemp : ListaElementos){
		
		out.println("<li>"+elemTemp+"</li>");
	}


%>   
</ul>
      <a href="menu.html">Voltar</a>


      </body>

</html>