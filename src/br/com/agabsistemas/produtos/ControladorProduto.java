package br.com.agabsistemas.produtos;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProduto
 */
@WebServlet("/ControladorProduto")
public class ControladorProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	private ModeloProduto modeloProduto;
	
	
	// estabelecer o datasource
	@Resource(name="jdbc/Produto")
	private DataSource meuPool;
	
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try{
		   modeloProduto = new ModeloProduto(meuPool);
		}catch(Exception erro ){
			throw new ServletException(erro);
		}
		
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// obter uma lista de produtos
		List<Produtos> produtos;
		try{
			produtos = modeloProduto.getProdutos();
		
		// agregar a lista de produtos no request
			request.setAttribute("LISTAPRODUTOS",produtos);
		// enviar o request a pagina jsp
			RequestDispatcher meuDispatcher= request.getRequestDispatcher("/ListaProdutos.jsp");
			
			meuDispatcher.forward(request,response);
		
		}			
		
		catch(Exception erro){
			erro.printStackTrace();
		}
		
		
	}



}
