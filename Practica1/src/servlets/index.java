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


@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public index() {
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
		  String tipo="";
		  String img="./img/discografia/";
		  String orden="";
		  String query="";
		  
		  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
		  sentencia = conn.createStatement();
		  
		//ORDENACION
		  if(request.getParameter("orden")!=null && request.getParameter("orden")!="" ) {
			  orden=request.getParameter("orden");
			  if(orden.equals("1")) {
				  query=" ORDER BY nombre ASC";
			  }if(orden.equals("2")) {
				  query= " ORDER BY nombre DESC";
			  }
		  }
		
		  
		//consulta basica
		  String consulta = "SELECT DISTINCT tipo FROM discos";
		//BUSQUEDA
		  if(request.getParameter("busqueda")!=null) {
			  String busqueda= request.getParameter("busqueda");
			  String[] arBusqueda= busqueda.split(" ");
			  if(arBusqueda.length>1) {
				  for(int i=0; i<arBusqueda.length;i++) {
					  if(i==0) {
					  	consulta+=" AND (nombre LIKE '%"+arBusqueda[i]+"%'"; 
					  }
					  if(i>0) {
						consulta+=" OR nombre LIKE '%"+arBusqueda[i]+"%'"; 
					  }
					  if(i==arBusqueda.length-1) {
						consulta+=" OR nombre LIKE '%"+arBusqueda[i]+"%')"; 
					  }
				  }
			  }else {
					consulta+=" AND nombre LIKE '%"+busqueda+"%'"; 
			  }
		  }
		  if(request.getParameter("tipo")!=null && request.getParameter("tipo")!="" ) {
			  tipo=request.getParameter("tipo");
			  consulta="SELECT * from discos WHERE tipo='"+tipo+"'"+query;
			  out.println(consulta);
			  
		  }
		  
		  //ejecucion de la consulta
		  ResultSet rset = sentencia.executeQuery(consulta);
		  out.println("<table border=1>");
		  //disco con el parametro tipo
		  if(request.getParameter("tipo")!=null) {
			  out.println("<h1>"+tipo+"</h1>");
			  out.println("<tr>" + "<td>Titulo <a href='./index?tipo="+tipo+"&orden=1'>&#9650  <a href='./index?tipo="+tipo+"&orden=2'>&#9660 </td>"+"<td> Discografica</td>" + "<td> Año</td>"+"<td> Formato</td>"+"<td>Imagen</td>"+"</tr>" );
			  while(rset.next()) {
				  out.println("<tr>" + "<td>"+rset.getString("nombre")+"</td>"+
				  "<td>"+rset.getString("discografica")+
				  "</td>"+"<td>"+rset.getString("year")+
				  "<td>"+rset.getString("soporte")+"</td>"+ 
				  "<td><a href='./disco?id="+rset.getString("id")+"'> <img src='"+img+ rset.getString("imagen")+".jpg" +"' width='100px'/></a></td></tr>");
			  }	
			//FORMULARIO BUSQUEDA
			  out.println("<form>"); 
			  out.println("<form action='/Practica1/index?tipo="+tipo+"' method='post'>"
						+ "Buscar por Obra:<input type='text' name='busqueda'  placeholder='Buscar'/><br>"
						+ "<input type='submit' name='buscar'><br><br>"
						+ "</form><br><br><br><br>");
			  out.println("<a href='./index '> Volver </a>");
			  //si no recibe parametro, las distintas categorias
		  }else {
		  out.println("<ul>" + "<li>Categorias</li>"+"</ul>" );
		  
			  while(rset.next()) {
				  out.println("<ul>" +
				 "<li><a href='./index?tipo="+rset.getString("tipo")+"'>"+rset.getString("tipo")+"</a></li>"+ 
				 "</ul>");
			  }
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
		
	}

}
