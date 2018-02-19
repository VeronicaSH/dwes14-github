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


@WebServlet("/MostrarAnimales")
public class MostrarAnimalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MostrarAnimalesServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext contexto = getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/></head><body>");
		//conexion con la BBDD
		Connection conn = null;
		Statement sentencia = null;
		try {
		  // Paso 1: Cargar el driver JDBC.
		  Class.forName("org.mariadb.jdbc.Driver").newInstance();

		  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
		  String userName = "alumno";
		  String password = "alumno";
		  String url = "jdbc:mariadb://localhost/animales";
		  conn = DriverManager.getConnection(url, userName, password);

		  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
		  sentencia = conn.createStatement();

		  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
		  String consulta = "SELECT * from animal";
		  ResultSet rset = sentencia.executeQuery(consulta);
		  //detectar si no hay resultados
		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
		  //variable imagen
		  String img="./img/";
		  // Paso 5: Mostrar resultados
		  out.println("<table>");
		  out.println("<tr>" + "<td>Chip</td>"+ "<td>Nombre</td>" + "<td>Animal</td>" +  "<td>Imagen</td>"+"</tr>" );
		  while (rset.next()) {
			
		    out.println("<tr>" + "<td>" + rset.getString("chip")+"</td>"+
		    "<td>"+ rset.getString("nombre") + "</td>" +
		    "<td>"+ rset.getString("especie") + "</td>" +
		    "<td> <img src='  "+img+ rset.getString("imagen") +"   ' width='100px'></td></tr>");
		  }
		  out.println("</table>");

		  // Paso 6: Desconexión
		  if (sentencia != null)
		    sentencia.close();
		  if (conn != null)
		    conn.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
