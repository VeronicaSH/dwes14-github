package servlets;

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


@WebServlet("/Borrar")
public class BorrarTema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BorrarTema() {
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
			 String url = "jdbc:mariadb://localhost/examen1718-1ev-sigurros";
			 conn = DriverManager.getConnection(url, userName, password);
			sentencia = conn.createStatement();
			String tema= request.getParameter("temas");
			ResultSet rset = sentencia.executeQuery(consultaComprobacion);
			if (!rset.isBeforeFirst() ) {    
				System.out.println("No hay resultados");
			}else {
				  rset.next();
				  sentencia.executeQuery("DELETE FROM temas WHERE id = '"+tema+"'");
				  response.sendRedirect(contexto.getContextPath() + "/Baja");
			}
			
		}catch (Exception e) {
			
		}
	}

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
