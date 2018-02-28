package cuenta;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;


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
			 // a. Error: el campo login no puede estar vacío 
			if(request.getParameter("login")==null) {
					//if( request.getParameter("login").isEmpty()) 
					mensajeError+="Error: el campo login no puede estar vacío ";
			}else if(request.getParameter("password")==null) {
				//if(request.getParameter("password").isEmpty())
				 // b. Error: el campo password no puede estar vacío
					mensajeError+="Error: el campo password no puede estar vacío ";
			} try {
				 // c. Error: no se encuentra el usuario en la base de datos
				Class.forName("org.mariadb.jdbc.Driver").newInstance();
				//conexion con la BBDD
				 String userName = "alumno";
				 String password = "alumno";
				 String url = "jdbc:mariadb://localhost/catalogo14";
				 Connection conn = DriverManager.getConnection(url, userName, password);
				
				Statement sentencia = null;
				sentencia = conn.createStatement();
				//consulta para comprobar el usuario
				String consulta = "SELECT * FROM usuario where login=\""+request.getParameter("login")+"\"";
				System.out.print(consulta);
				//ejecucion de la consulta
				ResultSet rset = sentencia.executeQuery(consulta);
				if (!rset.isBeforeFirst() ) {    
					  mensajeError+="Error: no se encuentra el usuario en la base de datos";
				}else {
					// d. Error: la contraseña no es válida
					while (rset.next()) {
						if(!rset.getString("password").equals(request.getParameter("password"))) {
							 mensajeError+="Error: la contraseña no es válida";
						}else {
							// 1. Crear un objeto de la clase Usuario con los datos obtenidos de la BD
							Usuario usuario=new Usuario(rset.getString("login"), rset.getString("password"), rset.getString("nombre"), rset.getBoolean("admin"), rset.getString("descripcion"));
							// 2. Crear una nueva sesión y avisarlo en un mensaje de log:
			              	session = request.getSession(); // en este caso sin "false" para que se cree
			              	//atributo de usuario y login
			              	session.setAttribute("usuario", usuario);
			              	session.setAttribute("login", rset.getString("login"));
							contexto.log(" * Creando sesión en " + request.getRequestURI());
							// 4. Redirigir al contenido
							response.sendRedirect(contexto.getContextPath() + "/Catalogo");
						}
					}
					
				}
              	
				
              
				if (rset != null)
				    rset.close();
				  if (sentencia != null)
				    sentencia.close();
				  if (conn != null)
				    conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			  
          
			// salida : L4
			PrintWriter out = response.getWriter();
			response.setContentType("text/html;UTF-8");
			out.println("<html><head><meta charset='UTF-8'/>" 
                        + "<style> .error {color: red}</style>"
                        + "<title>Catálogo de Nombre Apellidos</title></head><body>");
			out.println("<h3>Inicio de sesión</h3>");
			out.println("<form action='" + request.getRequestURI() + "' method='post'>"
					+ "<label>Usuario:</label><input type='text' name='login'><br/>"
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
