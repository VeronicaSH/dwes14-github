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


@WebServlet("/disco")
public class disco extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public disco() {
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
				  String url = "jdbc:mariadb://localhost/examen1718-1ev-sigurros";
				  conn = DriverManager.getConnection(url, userName, password);
				  String id="";
				  String img="./img/discografia/";
				  
				  
				  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
				  sentencia = conn.createStatement();
		//consulta basica
		String consulta="SELECT * FROM discos";
		//parametro del id
		//ejecucion de la consulta
		  ResultSet rset = sentencia.executeQuery(consulta);
		 
		  
		if(request.getParameter("id")!=null) {
			//DISCO
			  id=request.getParameter("id");
			  consulta="SELECT * from discos WHERE id='"+id+"'";
			  out.println(consulta );
			  rset = sentencia.executeQuery(consulta);
			  rset.next();
			  out.println("<img src='"+img+ rset.getString("imagen")+".jpg" +"' width='100px'/>");
			  out.println("<table border=1>");
			  out.println("<tr>" + "<td>Titulo </td>"+"<td> Discografica</td>" + "<td> Año</td>"+"<td> Formato</td>"+"</tr>" );
			
				  out.println("<tr>" + 
				"<td>"+rset.getString("nombre")+"</td>"+
				"<td><a href='"+rset.getString("discografica_e")+"'>"+rset.getString("discografica")+"</a></td>"+
				"<td>"+rset.getString("year")+"</td>"+
				"<td>"+rset.getString("soporte")+"</td>"+
				"</tr>");
			//CANCIONES
				  String consulta2="SELECT * from temas WHERE id_disco='"+id+"'";
				  out.println(consulta2);
				  ResultSet rset2 = sentencia.executeQuery(consulta2);
				  out.println("<h1>Listado de canciones<h1>");
				  out.println("<table border=1>");
				  out.println("<tr>" + "<td>Numero </td>"+"<td> Titulo</td>" + "<td> Duracion</td>"+"</tr>" );
				  while(rset2.next()) {
					  out.println("<tr>" );
					  out.println("<td>"+rset2.getString("numero")+"</td>");
					  out.println("<td>"+rset2.getString("nombre_i")+"</td>");
					  if(rset2.getString("minutos")==null||rset2.getString("segundos")==null) {
						  out.println("<td> No hay datos</td>");
					  }else {
						  out.println("<td>"+rset2.getString("minutos")+":"+rset2.getString("segundos")+" </td>");
					  }
					
					out.println("</tr>");
				  }
				  //out.println("<h1>Listado de comentarios<h1>");
				  
				  out.println(rset.getString("texto"));
				  
				  
		}
		
		  
		 out.println("</table>");
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
