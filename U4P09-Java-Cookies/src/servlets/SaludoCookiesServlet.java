package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Saludo")
public class SaludoCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaludoCookiesServlet() {
        super();
       
    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			ServletContext contexto = getServletContext();
			response.setContentType("text/html;UTF-8");
			PrintWriter out = response.getWriter();
			//procesamiento de la eliminacion de la cookie
			if (request.getParameter("eliminarCookie") != null) {
				Cookie cookieCaducada = new Cookie("usuario","");
				cookieCaducada.setMaxAge(0);
				response.addCookie(cookieCaducada);
				// es necesario refrescar para que se lea la cookie
				response.sendRedirect(request.getRequestURI());
			}
			String errorUsuario = "";
			String usuario = "";
			// procesamiento del formulario
			if (request.getMethod().equals("POST")) { // si se ha enviado el formulario...
				// validar nombre
				usuario = request.getParameter("usuario");
				if (usuario == "") {
					errorUsuario = "Debes introducir un nombre";
				} else{
					//creacion de la cookie
					Cookie nuevaCookieUsuario = new Cookie("usuario", usuario);
					nuevaCookieUsuario.setPath("/U4P09-Java-Cookies");
					response.addCookie(nuevaCookieUsuario);
					//para que la cookie no vaya con retardo	
					response.sendRedirect(request.getRequestURI());
					//para sobreescribir la cookie, cambiar el valor
					Cookie cookieModificada = new Cookie("login","nuevoValor");
					response.addCookie(cookieModificada);
					response.sendRedirect("/Saludo");
				}
			}
			
			

			// se empieza a generar la salida HTML
			out.println("<html><head><meta charset='UTF-8'/>" + "<style> .error {color: red}</style>" + "</head><body>");

			Cookie cookieUsuario = buscarCookie("usuario", request);
			if (cookieUsuario != null) {
				out.println("<h2>Bienvenid@, " + cookieUsuario.getValue() + "</h2>");
			} else {

				out.println("<form action='"+request.getRequestURI()+"' method='post'>"
						+ "<label>Introduce tu nombre para dirigirnos a ti:</label>" + "<input type='text' name='usuario'/>"
						+ "<span class='error'>" + errorUsuario + "</span><br/>"
						+ "<input type='submit' name='enviar' value='Enviar'/>"+ "<label>Recargar nombre:</label>" + "<input type='text' name='usuario'/>"+
						"</form>");
			}
			out.println("<p><a href='" + request.getRequestURI() + "'>Refrescar</a></p>");
			out.println("</body></html>");
			//eliminacion d la cookie
			out.println("<p><a href='" + request.getRequestURI() + "?eliminarCookie=true'>Eliminar cookie</a></p>");
			out.close();
			
	}

	//si no existe la cookie devuelve nulo
	private Cookie buscarCookie(String nombreCookie, HttpServletRequest request) {
			
			return null;
		}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
