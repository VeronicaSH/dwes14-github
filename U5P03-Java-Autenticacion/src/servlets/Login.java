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


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Login() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false); // L1
		ServletContext contexto = getServletContext();
		String mensajeError = "";
		// si ya había sesión con un valor de usuario válido
		if (session != null) {
			if ((session.getAttribute("login") != null)) { // L2
				response.sendRedirect(contexto.getContextPath() + "/"); // L3
			}
		}
		else { // no hay sesión iniciada
			if (request.getMethod().equals("POST")) { 
			  // si venimos de enviar el formulario...
              // Procesar los campos del formulario de login y password
              // Declarar una variable de mensaje de error para mostrar después:
			  // Comprobaciones que debes hacer:
              // a. Error: el campo login no puede estar vacío 
              // b. Error: el campo password no puede estar vacío
              // c. Error: no se encuentra el usuario en la base de datos
              // d. Error: la contraseña no es válida
              // Si todo ha ido bien:
              	// 1. Crear un objeto de la clase Usuario con los datos obtenidos de la BD
				// 2. Crear una nueva sesión y avisarlo en un mensaje de log:
              	session = request.getSession(); // en este caso sin "false" para que se cree
				contexto.log(" * Creando sesión en " + request.getRequestURI());
              	// 3. Añadir los atributos de sesión "login" y "usuario"
              	// 4. Redirigir al contenido
            }
			// salida : L4
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;UTF-8");
			out.println("<html><head><meta charset='UTF-8'/>" 
                        + "<style> .error {color: red}</style>"
                        + "<title>Catálogo de Nombre Apellidos</title></head><body>");
			out.println("<h3>Inicio de sesión</h3>");
			out.println("<form action='" + request.getRequestURI() + "' method='post'>"
					+ "<label>Usuario:</label><input type='text' name='username'><br/>"
					+ "<label>Contraseña:</label><input type='password' name='password'><br/>"
					+ "<input type='submit' value='Iniciar sesión' name='enviar'>" 
                    + "</form>" + "<p><a href='"
					+ contexto.getContextPath() + "/Alta'>¿Aún no estás registrado? Haz clic en este enlace</a></p>"
					+ "<h3>" + mensajeError + "</h3>");
			out.println("</body></html>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
