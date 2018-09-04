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
			throw new ServletException("erro no controlador (metodo init) ->"+erro);
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Ler o Parametro do Formulário
		String oComando=request.getParameter("instrucao");
		// se não houver parametro, listar produtos
		if (oComando==null) oComando="listar";
		// se houver parametro executar parametro adequado
		
		switch (oComando) {
		case "listar":obtemProdutos(request, response);
			break;
		case "insereBBDD": 
			 inserirProduto(request, response);
			 break;
		case "carregar":
			 try {
				carregaProdutos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
		case "alterarBBDD": 
			 try {
				atualizaProdutos(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
		case "excluir": 
			 try {
				excluirProduto(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
			 
			 
		default: 
			// obter uma lista de produtos
			obtemProdutos(request, response);
		}
		
	}

	private void excluirProduto(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 try {
			 
			// capturar código produto
			int iCodigo 	  = Integer.parseInt(request.getParameter("CProduto"));
					 
			 
			// excluir produto da base de dados
			modeloProduto.excluirProduto(iCodigo); 
			 
			// voltar a listagem de produtos
			obtemProdutos(request, response);
				 
			 
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void atualizaProdutos(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// Ler os dados do formulario atualizar
		int iCodigo 	  = Integer.parseInt(request.getParameter("cProduto"));
		String cDescricao = request.getParameter("cdescricao");
		int iQuantidade   = Integer.parseInt(request.getParameter("iquantidade"));
		double dPreco     = Double.parseDouble(request.getParameter("dpreco"));
		int iFabricante   = Integer.parseInt(request.getParameter("ifabcodigo"));
	
		
		// Criar objeto com dados vindos do formulario atualizar
		
		Produto ProdutoAlterado= new Produto(iCodigo, cDescricao, dPreco, iQuantidade, iFabricante);
		try {
		
		// Atualizar banco de dados
		modeloProduto.alterarProduto(ProdutoAlterado);
		
		// voltar a listaprodutos com dados atualizados
		obtemProdutos(request, response);
		}catch(Exception erro){
			erro.printStackTrace();
		}
	}

	private void carregaProdutos(HttpServletRequest request, HttpServletResponse response)throws Exception {
		// TODO Auto-generated method stub
		// Ler o Código do Produto que vem da listagem
	    String cCodigo = request.getParameter("CProduto");			
	    try{
	    	// informar codigo produto ao modelo 
	    	Produto oProduto = modeloProduto.buscaProduto(cCodigo);
	
		
		// Receber os dados da pesquisa informada do Código do Produto
			request.setAttribute("ProdutoAlterar", oProduto);
			
			// Enviar todos os dados recebidos ao formulario atualizar
			RequestDispatcher dispatcher=request.getRequestDispatcher("/atualizarProduto.jsp");
			dispatcher.forward(request, response);
		
	    }catch(Exception erro){
			erro.printStackTrace();
		}
		
	}

	private void inserirProduto(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		// Ler as informações do formulário inserção
		int iCodigo 	  = Integer.parseInt(request.getParameter("icodigo"));
		String cDescricao = request.getParameter("cdescricao");
		int iQuantidade   = Integer.parseInt(request.getParameter("iquantidade"));
		double dPreco     = Double.parseDouble(request.getParameter("dpreco"));
		int iFabricante   = Integer.parseInt(request.getParameter("ifabcodigo"));
		
		// Criar objeto do tipo Produtos => Classe Produtos
		
		Produto NovoProduto = new Produto(iCodigo, cDescricao, dPreco, iQuantidade, iFabricante);
		
		// Enviar ao modelo e depois inserir objeto produto na base de dados
		try {
			
		modeloProduto.insereProdutoNovo(NovoProduto);
		
		// atualizar a tabela de produtos - comprovar a inserção
		obtemProdutos(request, response);
		}catch(Exception erro){
			erro.printStackTrace();
		}
	
	}

	private void obtemProdutos(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		//obtem uma lista de produtos  

		List<Produto> produtos;
		try{
			produtos = modeloProduto.buscaProdutos();
		
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
