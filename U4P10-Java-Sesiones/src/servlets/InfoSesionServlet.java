package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/InfoSesionServlet")
public class InfoSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InfoSesionServlet() {
        super();
    }   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Crear una sesión o recuperar la existente si se encuentra la cookie de sesión
		HttpSession session = request.getSession();
		String primeraVez="";
		String reiniciarSesion;
		
		
		if(request.getParameter("reiniciarSesion") != null) {
			session.invalidate();
			session = request.getSession();
		}
		
		int contador = 0;
		// Comprobar si es la primera vez
		
		if (session.isNew()) {
			//variable primeraVez se muestra solo al iniciar la pagina
			//inicializacion de variable primeraVez al iniciar sesion
		  session.setAttribute("primeraVez", "Primera Vez en la pagina");
		  session.setAttribute("contador", 0);
		  primeraVez=(String) session.getAttribute("primeraVez");
		  //(duracion de la sesion)session.setMaxInactiveInterval(5);
		} else {
		  contador = (int) session.getAttribute("contador");
		  contador++;
		  session.setAttribute("contador", contador);
		 
		}
		
		
		// Obtener datos sobre la sesión
		Date fechaInicioSesion = new Date(session.getCreationTime());
		// Obtener la fecha del último acceso
		Date fechaUltimoAcceso = new Date(session.getLastAccessedTime());
		// Comienza la salida...
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/>" + "<style> .error {color: red}</style>"
		    + "<title>Sesiones en JavaEE</title></head><body>");
		response.setContentType("text/html;UTF-8");
		out.println("<h2>Información sobre la sesión</h2>" +
		            "<ul>" +
		            "<li> Identificador: " + session.getId() + "</li>\n" +
		            "<li> Fecha de creación: " + fechaInicioSesion + "</li>\n" +
		            "<li> Fecha de último acceso: " + fechaUltimoAcceso + "</li>\n" +
		            "<li> Número de visitas: " + contador + "</li>\n" +
		            "</ul>" +primeraVez+
		            
		        "<p><a href='" + request.getRequestURI() + "'>Refrescar</a></p>");
		out.println("<p><a href='" + request.getRequestURI() + "?reiniciarSesion=true'>Borrar la sesión</a></p>");
		out.println("<p><a href='" + response.encodeURL(request.getRequestURI())+ "'>Refrescar con reescritura de URL</a></p>"); 
		out.println("</body></html>");
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
