package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="FechaServlet", urlPatterns="/Fecha")
public class FechaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FechaServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/></head><body>");
		out.println("<body><h1>Servlet sencillo que muestra la fecha actual</h1>");
		Date fecha = new Date();
		DateFormat df = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		out.println("<p>Fecha: "+df.format(fecha)+"</p>");
		out.println("<p><a href='./index.html'>Volver al inicio</a></p>");
		out.println("</body></html>");
		//out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
