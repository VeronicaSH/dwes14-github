package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Producto;
import modelo.Usuario;


@WebServlet("/AniadirCesta")
public class AñadirCesta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AñadirCesta() {
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
				  String id="";
				  
				  //Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
				  sentencia = conn.createStatement();
				  
				  //RECUPERAR SESION
				  HttpSession session = request.getSession(false);
				  //si no hay sesion redirigir a login
					if(session==null) {
						response.sendRedirect(contexto.getContextPath() + "/Login");
					}
					//PARAMETRO IDPRODUCTO
					if(request.getParameter("idproducto")!=null && request.getParameter("idproducto")!="" ) {
						id=request.getParameter("idproducto");
						String consulta3="SELECT * FROM producto WHERE idproducto="+id+"";
						ResultSet rset3 = sentencia.executeQuery(consulta3);
						rset3.next();
						Producto compra=new Producto(rset3.getInt("idProducto"), rset3.getString("nombre"), rset3.getString("marca"),  rset3.getInt("precio"),  rset3.getInt("stock"));
						//RECUPERAR LA SESION DEL CARRITO
						if(session!=null) {
						ArrayList <Producto> carrito=(ArrayList<Producto>) session.getAttribute("carrito");
						carrito.add(compra);
						//String referrer = request.getHeader("referer");
						response.sendRedirect(contexto.getContextPath()+"/Login");
						}else {
							System.out.print("NO ENTRA");
						}
					}else {
						System.out.print("NO ENTRA");
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
