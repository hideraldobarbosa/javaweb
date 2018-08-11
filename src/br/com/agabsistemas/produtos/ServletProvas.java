package br.com.agabsistemas.produtos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class ServletProvas
 */
@WebServlet("/ServletProvas")
public class ServletProvas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	// estabelecer o datasource
	@Resource(name="jdbc/Produto")
	private DataSource meuPool;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProvas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// Criar objeto PrintWritter
		PrintWriter saida = response.getWriter();
		response.setContentType("text/plain");
		
		Connection minhaConexao = null;
		Statement meuStatement = null;
		ResultSet meuResultset = null;
		
		try{
			
			minhaConexao = meuPool.getConnection();
			String meuSql = "Select * from produto";
			meuStatement = minhaConexao.createStatement();
			meuResultset = meuStatement.executeQuery(meuSql);
			
			while(meuResultset.next()){
				String nomeProduto= meuResultset.getString(2);
				saida.println(nomeProduto);
			}
			
			
		}
		catch(Exception erro){
			erro.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
