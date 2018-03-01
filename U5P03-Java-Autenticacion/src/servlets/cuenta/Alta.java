package servlets.cuenta;

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

@WebServlet("/Alta")
public class Alta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Alta() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext contexto=getServletContext();
		Connection conn = null;Statement sentencia = null;
		String consultaComprobacion = "SELECT * from usuario WHERE login='"+contexto.getAttribute("login")+"'";
		String consultaAlta = "INSERT INTO `usuario` (`login`, `password`, `nombre`, `admin`, `descripcion`) VALUES ('"	+request.getParameter("username")+"', '"+request.getParameter("password")+"', '"+request.getParameter("nombre")+"' , '"+request.getParameter("admin") +"', '"+request.getParameter("descripcion")+"');";
		String mensajeError="";
		PrintWriter out = response.getWriter();
		if(request.getParameter("enviar")!=null) {
			try {
				Class.forName("org.mariadb.jdbc.Driver").newInstance();
				 String userName = "alumno";
				 String password = "alumno";
				 String url = "jdbc:mariadb://localhost/catalogo14";
				  conn = DriverManager.getConnection(url, userName, password);
				sentencia = conn.createStatement();
				ResultSet rset = sentencia.executeQuery(consultaComprobacion);
				if (!rset.isBeforeFirst() ) {    
					sentencia.executeQuery(consultaAlta);
					response.sendRedirect(contexto.getContextPath() + "/Login?Creado=true");
				}else {
					mensajeError+="Ya existe el usuario";
				}
				if (rset != null)
				    rset.close();
				  if (sentencia != null)
				    sentencia.close();
				  if (conn != null)
				    conn.close();
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		response.setContentType("text/html;UTF-8");
		out.println("<html><head><meta charset='UTF-8'/>" + "<style> .error {color: red}</style>"
			+ "<title>Catálogo de Nombre Apellidos</title></head><body>");
				out.println("<h3>Alta de usuario</h3>");
				out.println("<form action='"+request.getRequestURI()+"' method='post'>"
			+ "<label>Usuario:</label><input type='text' name='username'><br/>\n"
			+ "<label>Contraseña:</label><input type='password' name='password'><br/>\n"
			+ "<label>Nombre:</label><input type='text' name='nombre'><br/>\n"
			+ "<label>Admin:</label> No <input type='radio' name='admin' value='0' checked/>\n"
			+ " Sí <input type='radio' name='admin' value='1'/><br/>\n"
			+ "<label>Descripción:</label><input type='textarea' name='descripcion'><br/>\n"
			+ "<input type='submit' value='Crear usuario' name='enviar'>\n"
			+ "</form>\n"
			+ "<p><a href='"+contexto.getContextPath()+"/Login'>¿Ya estás registrado? Haz clic en este enlace</a></p>\n"
			+ "<h3>"+mensajeError+"</h3>\n");
		out.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
