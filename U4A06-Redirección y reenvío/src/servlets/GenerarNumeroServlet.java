package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.deploy.ContextTransaction;

/**
 * Servlet implementation class GenerarNumeroServlet
 */
@WebServlet("/Sorpresa")
public class GenerarNumeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GenerarNumeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int num=(int)(Math.random()*100+1);
		request.setAttribute("numero", num);
		ServletContext contexto = getServletContext();

		
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Numero aleatoria de 1 al 100: "+num+"</h1>");
		out.println("<p><a href='./index.html'>Index</a></p>");
		
		out.close();
		
		
		
	}

}