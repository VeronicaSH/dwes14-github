package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SaludoServlet")
public class SaludoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaludoServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response, Object usuario) throws ServletException, IOException {
		
	//variable error
		String errorUsuario = "";
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//si la sesion es distinta de nulo 
		if( request.getSession() != null) {
			//recogemos el parametro de la request
			usuario = request.getParameter("usuario");
			out.println("Damos la bienvenida a " + usuario);
		//si se ha dado a enviar
		}else if(request.getMethod().equals("POST")) {
			//validamos el nombre
			usuario = request.getParameter("usuario");
			if (usuario == "") {
				errorUsuario = "Debes introducir un nombre";
			} else{
				//creacion de la sesion 
				HttpSession session = request.getSession();
				//añadimos el ususario
				 session.setAttribute("usuario", usuario);
				 //redirigir a la misma pagina
				 response.sendRedirect("/SaludoServlet");
			}
		}
			
		//se empieza a generar la salida HTML
		out.println("<html><head><meta charset='UTF-8'/>" + "<style> .error {color: red}</style>" + "</head><body>");
		out.println("<form action='"+request.getRequestURI()+"' method='post'>"
				+ "<label>Introduce tu nombre para dirigirnos a ti:</label>" + "<input type='text' name='usuario'/>"
				+ "<span class='error'>" + errorUsuario + "</span><br/>"
				+ "<input type='submit' name='enviar' value='Enviar'/>"+ "<label>Recargar nombre:</label>" + "<input type='text' name='usuario'/>"+
				"</form>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
