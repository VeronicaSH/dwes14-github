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


@WebServlet("/MostrarObra")
public class MostrarObra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MostrarObra() {
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
		  String errorNombre="";

		  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
		  sentencia = conn.createStatement();

		  //parametro recibido de la request
		  String idJuego = request.getParameter("idJuego");
		  //parametro de la request de idAutor
		  String idAutor=request.getParameter("idAutor");
		
		  //creacion de la consulta de idAutor
		  String consulta2="SELECT * from obra,autor WHERE (autor.idAutor=obra.autor) AND autor.idAutor="+idAutor;
			
		  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
		  String consulta = "SELECT * from obra,autor WHERE (autor.idAutor=obra.autor) AND obra.idJuego="+idJuego;
		  //primera consulta
		  ResultSet rset = sentencia.executeQuery(consulta);
		  //segunda consulta
		  ResultSet resultado = sentencia.executeQuery(consulta2);
		  
		  
		  
		  
		  
		  //detectar si no hay resultados
		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
		  //variable imagen
		  String img="./img/";
		  
		
		  // Paso 5: Mostrar resultados
		  out.println("<table>");
		  out.println("<tr>" + "<td>IdJuego</td>" + "<td>Nombre</td>" + "<td>Genero</td>"+ "<td>Consola</td>"  + "<td>Autor</td>"+  "<td>Imagen</td>"+ "</tr>"  );
		  rset.next();
			//objeto de la clase obra
			Obra o=new Obra(rset.getString("idJuego"), rset.getString("Nombre"), rset.getString("genero"), rset.getString("consola"), rset.getString("autor"), rset.getString("Imagen"), rset.getString("nombre_autor"));
			out.println("<tr>" + 
			//llamada a los get de la clase obra para recuperar los datos
			"<td>"+ o.getIdJuego() + "</td>" +
		    "<td>"+ o.getNombre() + "</td>" +
		    "<td>"+ o.getGenero() + "</td>" +
		    "<td>"+ o.getConsola() + "</td>" +
		    "<td>"+ o.getNombreAutor() + "</td>" +
		    "<td> <img src='"+img+ o.getImagen() +"' width='100px'></td></tr>");
		    
		  
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
