package br.com.agabsistemas.servlet246;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registrousuarios
 */
@WebServlet("/registrousuarios")
public class RegistroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistroUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter saida=response.getWriter();
		
		saida.println("<html><body>");
		saida.println("nome digitado ->"+request.getParameter("nome"));
		saida.println("<br><br>");
		saida.println("sobrenome digitado ->"+request.getParameter("sobrenome"));
		saida.println("</body></html>");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	    response.setContentType("text/html"); 
		PrintWriter saida=response.getWriter();
		
		saida.println("<html><body>");
		saida.println("nome digitado ->"+request.getParameter("nome"));
		saida.println("<br><br>");
		saida.println("sobrenome digitado ->"+request.getParameter("sobrenome"));
		saida.println("</body></html>");
	
	
	}

}
