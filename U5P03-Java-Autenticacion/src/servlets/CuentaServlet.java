package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;


@WebServlet("/Cuenta")
public class CuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CuentaServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext contexto=getServletContext();
		HttpSession session = request.getSession(false);
		PrintWriter out=response.getWriter();
		//si no hay sesion redirigir a login
		if(session==null) {
			response.sendRedirect(contexto.getContextPath() + "/Login");
		}else {
			Usuario usuario=(Usuario)session.getAttribute("usuario");
			out.println("<html><head><title>Cuenta</title></head><body>");
			out.println("<h1>Datos de la Cuenta</h1>");
			out.println("<ul>"
					+ "<li>Login: "+usuario.getLogin()
					+ "<li>Password: "+usuario.getPassword()
					+ "<li>Nombre: "+usuario.getNombre_usuario());
			if(usuario.isAdministrador()) {
				out.println("<li>Es una cuenta de administrador");
			}else {
				out.println("<li>Es una cuenta de usuario");
			}
			out.println("<li>Descripción: "+usuario.getDescripcion());
			out.println("</ul>");
			out.println("<a href=\""+contexto.getContextPath()+"/Logout\"<button>Cerrar Sesión</button></a>");
			out.println("<a href=\""+contexto.getContextPath()+"/Baja\"<button>Baja de cuenta</button></a>");
			out.println("<a href=\""+request.getHeader("Referer")+"\"<button>Volver</button></a>");
			out.println("</body></html>");
		}
	}
		
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
