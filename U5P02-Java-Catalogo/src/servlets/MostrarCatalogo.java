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


@WebServlet("/MostrarCatalogo")
public class MostrarCatalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MostrarCatalogo() {
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
		  String url = "jdbc:mariadb://localhost/catalogo14";
		  conn = DriverManager.getConnection(url, userName, password);

		  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
		  sentencia = conn.createStatement();

		  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
		  String consulta = "SELECT * from obra,autor WHERE autor.idAutor=obra.autor";
		  ResultSet rset = sentencia.executeQuery(consulta);
		  //detectar si no hay resultados
		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
		  //variable imagen
		  String img="./img/";
		  // Paso 5: Mostrar resultados
		  out.println("<table>");
		  out.println("<tr>" + "<td>Nombre &#9650  &#9660</td> " + "<td>Autor &#9650  &#9660</td>"+ "</tr>" );
		  while (rset.next()) {
			Obra o=new Obra(rset.getString("idJuego"), rset.getString("Nombre"), rset.getString("genero"), rset.getString("consola"), rset.getString("autor"), rset.getString("Imagen"), rset.getString("nombre_autor"));
			out.println("<tr>" + 
			//nombre_obra parametro de mostrar obra
			"<td><a href='./MostrarObra?idJuego="+o.getIdJuego()+"'>"+o.getNombre()+"</a></td> "+
		    "<td>"+ o.getNombreAutor() + "</td>" +
		    "</tr>");
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
