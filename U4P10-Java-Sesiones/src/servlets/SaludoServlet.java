package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Saludo")
public class SaludoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaludoServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response, Object usuario) throws ServletException, IOException {
		//inicio de sesion
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		//variable error
		String error="";
		//si el parametro de cerrarSesion es nulo
		if(request.getParameter("cerrarSesion") !=null) {
			//cerramos sesion
			session.invalidate();
			session = request.getSession();
			//volver a iniciar
			response.sendRedirect(request.getRequestURI());

		}
		//si la sesion es nueva
		if(session.isNew()) {
				
		}else {
		//si se ha dado a enviar	
		if (request.getMethod().equals("POST")) {
				//si el nombre no es nulo se guarda el atributo
				if (request.getParameter("nombre")!=null) {
					session.setAttribute("nombre", request.getParameter("nombre"));
				}else {
					//si es nulo mensaje de error
					error="No se ha enviado un nombre";
				}
			}
		}
		out.println("<html><body>");
		//si el atributo nombre no es nulo y no esta vacio
		if(session.getAttribute("nombre")!=null && !session.getAttribute("nombre").equals("") ) {
			//variable nombre
			String nombre =session.getAttribute("nombre").toString();
			
			out.println("<h1>Bienvenido "+nombre+"</h1>");
			//enlace de cerrar sesion 
			out.println("<a href='"+request.getRequestURI()+"?cerrarSesion=true'>Cerrar Sesion</a>");
		}else {
			//formulario
			out.println("<form action='"+request.getRequestURI()+"' method='post'>");
			out.println("<label>Introduce tu nombre:</label> <input type='text' name='nombre'/>");
			//mensaje de error si no se ha iniciado sesion
			out.println("<span class='error'>" + error + "</span><br/>");
			out.println("<input type='submit' name='enviar' value='Enviar'/></form>");
		}
		
		out.println("</body></html>");
		
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
