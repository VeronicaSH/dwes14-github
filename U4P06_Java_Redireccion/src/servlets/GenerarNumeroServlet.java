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


@WebServlet("/Sorpresa")
public class GenerarNumeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public GenerarNumeroServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int numero=(int)(Math.random()*100);
		request.setAttribute("numero", numero);
		ServletContext contexto = getServletContext();

		
		/*para sacar el numero
		PrintWriter out = response.getWriter();
		out.println("<h1>Numero aleatorio "+numero+"</h1>");
		out.println("<p><a href='./index.html'>Volver</a></p>");
		
		out.close();*/
		
		response.sendRedirect(contexto.getContextPath()+"/MostrarNumero");
		
		
	}

}