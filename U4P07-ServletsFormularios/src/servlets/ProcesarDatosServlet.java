package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.jrockit.jfr.parser.ParseException;

@WebServlet("/ProcesarDatos")
public class ProcesarDatosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ProcesarDatosServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String nombre=request.getParameter("nombre");
		String gender=request.getParameter("gender");
		String comentario=request.getParameter("comentario");
		out.println(nombre);
		out.println(gender);
		out.println(comentario);
		String [] valores=request.getParameterValues("gustos");
		out.println("<ul>");
		for(int i=0;i<valores.length;i++) {
			out.println("<li>" + valores[i] + "</li>");
		}
		out.println("</ul>");
		/*
		SimpleDateFormat formatoFecha=newSimpleDateFormat("yyyy-MM-dd");
		try {
			Date fecha= formatoFecha.parse(request.getParameter("fecha"));
			SimpleDateFormat formatoSalida=new SimpleDateFormat("dd/MM/yyyy");
			out.println("Fecha:" + formatoSalida.format(fecha));
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

	
	private SimpleDateFormat newSimpleDateFormat(String string) {
		// TODO Auto-generated method stub
		return null;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
