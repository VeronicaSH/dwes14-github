package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(urlPatterns={"/EjemploServletHttp","/SampleHttpServlet"})
public class EjemploServletHttp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public EjemploServletHttp() {
        super();
        
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;UTF-8");
		Calendar fechahora = new GregorianCalendar();
	    PrintWriter out = response.getWriter();
	    out.println("Fecha: " + 
	                fechahora.get(Calendar.DAY_OF_MONTH) + "/" +
	                (fechahora.get(Calendar.MONTH)+1) + "/" +
	                fechahora.get(Calendar.YEAR) + "<br>" );
	    out.println("Hora:  " + 
	                fechahora.get(Calendar.HOUR_OF_DAY) + ":" +
	                fechahora.get(Calendar.MINUTE) + ":" +
	                fechahora.get(Calendar.SECOND)+  "<br>" );
	    out.println("<a href=index.html>Volver</a>" );
	    out.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	public void init() {
	    log("Iniciando el servlet HTTP");
	  }

}
