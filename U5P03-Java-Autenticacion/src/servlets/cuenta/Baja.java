package servlets.cuenta;

import java.io.IOException;
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


@WebServlet("/Baja")
public class Baja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Baja() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		System.out.println(session.getAttribute("login"));
		String UserSesion=(String) session.getAttribute("login");
		ServletContext contexto=getServletContext();
		Connection conn = null;Statement sentencia = null;
		String consultaComprobacion = "SELECT * from usuario WHERE login='"+session.getAttribute("login")+"'";
		
		
		
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			 String userName = "alumno_rw";
			 String password = "dwes";
			 String url = "jdbc:mariadb://localhost/catalogo14";
			 conn = DriverManager.getConnection(url, userName, password);
			sentencia = conn.createStatement();
			ResultSet rset = sentencia.executeQuery(consultaComprobacion);
			if (!rset.isBeforeFirst() ) {    
				System.out.println("No hay resultados");
			}else {
				  rset.next();
				  sentencia.executeQuery("DELETE FROM usuario WHERE login = '"+rset.getString("login")+"'");
					if(UserSesion!=null) {
						session.invalidate();
					}
					response.sendRedirect(contexto.getContextPath() + "/Login?Borrado=true");
			}
			
		}catch (Exception e) {
			
		}
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
