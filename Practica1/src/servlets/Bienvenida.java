package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Bienvenida")
public class Bienvenida extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Bienvenida() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto = getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/></head><body>");
		out.println("Bienvenido");
		out.println("<p><a href='"+ contexto.getContextPath() + "/Baja'> Haz clic en este enlace para dar de baja temas</a></p>");
		out.println("<p><a href='"+ contexto.getContextPath() + "/Logout'> Cerrar Sesion</a></p>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
