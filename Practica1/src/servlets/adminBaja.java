package servlets;

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


@WebServlet("/Baja")
public class adminBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public adminBaja() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		System.out.println(session.getAttribute("login"));
		String UserSesion=(String) session.getAttribute("login");
		ServletContext contexto=getServletContext();
		Connection conn = null;Statement sentencia = null;
		PrintWriter out = response.getWriter();
		String consultaComprobacion = "SELECT * from usuario WHERE login='"+session.getAttribute("login")+"'";
		String consulta="SELECT * FROM temas ";
		
		
		try {
			Class.forName("org.mariadb.jdbc.Driver").newInstance();
			 String userName = "alumno_rw";
			 String password = "dwes";
			 String url = "jdbc:mariadb://localhost/examen1718-1ev-sigurros";
			 conn = DriverManager.getConnection(url, userName, password);
			sentencia = conn.createStatement();
			ResultSet rset = sentencia.executeQuery(consultaComprobacion);
			if (!rset.isBeforeFirst() ) {    
				response.sendRedirect(contexto.getContextPath() + "/Login");
			}else {
				ResultSet rset2 = sentencia.executeQuery(consulta);
				out.println("<form action='" + request.getRequestURI() + "' method='post'>");
				 out.println("<select name='temas'>");
				 while(rset2.next()) {
				 out.println("<option value="+rset2.getString("id")+">"+rset2.getString("nombre_e")+"</option> ");
				 }
				 out.println("</select>");  
				 out.println("<input type='submit' value='Borrar'>");
				 out.println("</form>");   
				 
				  //sentencia.executeQuery("DELETE FROM temas WHERE id = '"++"'");
					//if(UserSesion!=null) {
						session.invalidate();
					//}
					//response.sendRedirect(contexto.getContextPath() + "/Login?Borrado=true");
			}
			
		}catch (Exception e) {
			
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
