package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MostrarCuidadores")
public class MostrarCuidadoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MostrarCuidadoresServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("Cuidadores </br>");
		out.println("<a href='/U5P01-Java-BBDD/MostrarCuidador?idCuidador=12345'>Alberto</a> </br>");
		out.println("<a href='/U5P01-Java-BBDD/MostrarCuidador?idCuidador=23243'>Luis</a> </br>");
		out.println("<a href='/U5P01-Java-BBDD/MostrarCuidador?idCuidador=54321'>Aurea</a> </br>");
		out.println("Enlace a la BBDD de Animales");
		out.println("<a href='/U5P01-Java-BBDD/MostrarAnimales'>Animales de la BBDD</a> </br>");

		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
