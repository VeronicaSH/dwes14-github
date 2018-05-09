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

import modelo.Usuario;


@WebServlet("/MostrarDetalle")
public class Mostrar_Detalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Mostrar_Detalle() {
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
		  String url = "jdbc:mariadb://localhost/supermercado";
		  conn = DriverManager.getConnection(url, userName, password);
		 

		  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
		  sentencia = conn.createStatement();
		//RECUPERAR SESION
		  HttpSession session = request.getSession(false);
		//si no hay sesion redirigir a login
			if(session==null) {
				response.sendRedirect(contexto.getContextPath() + "/Login");
			}else {
				Usuario usuario=(Usuario)session.getAttribute("usuario");
				out.println("<h1>Sesion iniciada por "+usuario.getLogin()+"</h1>");
			}
		  //parametro recibido de la request id producto
		  String idproducto = request.getParameter("idproducto");
		  
		
		  //creacion de la consulta de idAutor
		  String consulta="SELECT * from producto,ubicacion,cliente WHERE (producto.idproducto=ubicacion.idubicacion) AND idproducto="+idproducto;
		  
		  
		  //ejecucion de la consulta
		  ResultSet rset = sentencia.executeQuery(consulta);
		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
			}
		  //variable imagen
		  String img="./img/productos/";
		  
		  out.println("<table>");
		  out.println("<tr>" + "<td>Nombre</td>" + "<td>Marca</td>"+ "<td>Precio</td>"  + "<td>Stock</td>"+  "<td>Descripcion</td>"+   "<td>Imagen</td>" + "<td>Pasillo</td>" + "<td>Modulo</td>"+ "<td>Altura</td>"  + "<td>Hueco</td>"+"</tr>" );
		  rset.next();
			
			out.println("<tr>" + 
			//llamada a los get de la clase obra para recuperar los datos
			"<td>"+ rset.getString("nombre") + "</td>" +
		    "<td>"+ rset.getString("marca") + "</td>" +
		    "<td>"+ rset.getString("precio") + "</td>" +
		    "<td>"+ rset.getString("stock") + "</td>" +
		    "<td>"+ rset.getString("descripcion") + "</td>" +
		    "<td> <img src='"+img+rset.getString("imagen") +"' width='100px'></td>"+
		    "<td>"+ rset.getString("pasillo") + "</td>" +
		    "<td>"+ rset.getString("modulo") + "</td>" +
		    "<td>"+ rset.getString("altura") + "</td>" +
		    "<td>"+ rset.getString("hueco") + "</td>" +"</tr>");
		    
		  
		  
		  
		  out.println("</table>");
		  out.println("<a href='./Mostrarproductos?familia=\""+ rset.getString("familia")+"\"'> Volver </a>");
		// Paso 6: Desconexión
		  if (sentencia != null)
			    sentencia.close();
			  if (conn != null)
			    conn.close();
			} catch (Exception e) {
			  e.printStackTrace();
			}
		
	}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
