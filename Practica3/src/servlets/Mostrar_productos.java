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

@WebServlet("/Mostrarproductos")
public class Mostrar_productos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Mostrar_productos() {
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
				  String img="./img/productos/";
				  String carro="./img/carrito1.png";
				  String familia="";
				  String idProducto="";
				  
				  //Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
				  sentencia = conn.createStatement();
				  
				 //RECUPERAR SESION
				  HttpSession session = request.getSession(false);
				//si no hay sesion redirigir a login
					if(session==null) {
						response.sendRedirect(contexto.getContextPath() + "/Login");
					}else {
						Usuario usuario=(Usuario)session.getAttribute("usuario");
						out.println("<h1>Sesion iniciada por <a href='" + contexto.getContextPath() + "/Cuenta'>"+usuario.getNombre()+"</a></h1>");
					}
				  
				  //PARAMETRO DE FAMILIA
				  out.println("<table>");
				  if(request.getParameter("familia")!=null && request.getParameter("familia")!="" ) {
					  familia=request.getParameter("familia");
					  String consulta2 = "SELECT * from producto WHERE familia="+familia+"";
					  ResultSet rset2 = sentencia.executeQuery(consulta2);
					  out.println("<h1>"+familia+"</h1>");
					  out.println("<tr>"+"<td>Nombre</td>"+"<td>Marca</td>"+"<td>Imagen</td>"+"<td>Añadir</td>"+"</tr>" );
					  while(rset2.next()) {
						  out.println("<tr>" + "<td><a href='./MostrarDetalle?idproducto="+rset2.getString("idproducto")+"'>"+rset2.getString("nombre")+"</a></td> "+ 
								  "<td>"+ rset2.getString("marca")+"</td>"
								  + "<td> <img src='"+img+ rset2.getString("imagen") +"' width='100px'></td>"+
								  "<td><a href="+contexto.getContextPath() + "/AniadirCesta?idproducto="+rset2.getString("idproducto")+">"+ "<img src='"+carro+"'width='100px'></td>"+"</tr>");
					  }
				  }else {
					
					//consulta basica
					  String consulta = "SELECT DISTINCT familia from producto ";
					  System.out.print(consulta);
					  ResultSet rset = sentencia.executeQuery(consulta);
					  out.println("<tr>"+"<td>Producto</td>"+"<tr>");
					  	while(rset.next()) {
							  out.println("<tr>" + "<td><a href='./Mostrarproductos?familia=\""+ rset.getString("familia")+"\"'>"+rset.getString("familia")+"</td>"+"</tr>");
					  	}
				  }
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
