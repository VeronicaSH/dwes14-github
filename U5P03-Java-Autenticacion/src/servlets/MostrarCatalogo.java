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

import model.Autor;
import model.Obra;
import model.Usuario;


@WebServlet("/Catalogo")
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
		  String orden="";
		  String query="";
		  String id="";
		  
		  // Paso 3: Crear sentencias SQL, utilizando objetos de tipo Statement
		  sentencia = conn.createStatement();
		  
		  
		 
		  //ORDENACION
		  if(request.getParameter("orden")!=null && request.getParameter("orden")!="" ) {
			  orden=request.getParameter("orden");
			  if(orden.equals("1")) {
				  query=" ORDER BY obra.Nombre ASC";
			  }if(orden.equals("2")) {
				  query= " ORDER BY obra.Nombre DESC";
			  }
		  }
		  //consulta basica con ordenacion
		  String consulta = "SELECT * from obra,autor WHERE autor.idAutor=obra.autor"+query+"";
		  
		  
		  //BUSQUEDA
		  if(request.getParameter("busqueda")!=null) {
			  String busqueda= request.getParameter("busqueda");
			  String[] arBusqueda= busqueda.split(" ");
			  if(arBusqueda.length>1) {
				  for(int i=0; i<arBusqueda.length;i++) {
					  if(i==0) {
					  	consulta+=" AND (obra.Nombre LIKE '%"+arBusqueda[i]+"%'"; 
					  }
					  if(i>0) {
						consulta+=" OR obra.Nombre LIKE '%"+arBusqueda[i]+"%'"; 
					  }
					  if(i==arBusqueda.length-1) {
						consulta+=" OR obra.Nombre LIKE '%"+arBusqueda[i]+"%')"; 
					  }
				  }
			  }else {
					consulta+=" AND obra.Nombre LIKE '%"+busqueda+"%'"; 
			  }
		  }
		  
		  
		  
		  
		  //parametro de autor
		  if(request.getParameter("idAutor")!=null && request.getParameter("idAutor")!="" ) {
			  id=request.getParameter("idAutor");
			  consulta="SELECT * from obra,autor WHERE (autor.idAutor=obra.autor) AND autor.idAutor="+id;
			  System.out.println(consulta);
		  }
		  
		
		  
		  
		  
		  ResultSet rset = sentencia.executeQuery(consulta);
		  //detectar si no hay resultados
		  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>No hay resultados</p>");
		  }
		  //variable imagen
		  String img="./img/";
		  // Paso 5: Mostrar resultados
		  out.println("<table border=1>");
		  
		  
		  //AUTORES
		  if(request.getParameter("idAutor")!=null) {
			  out.println("<tr>" + "<td>Id Autor</td>"+"<td>Nombre Autor</td>" + "<td>Obras</td>"+"</tr>" );
			  while(rset.next()) {
				  Obra o=new Obra(rset.getString("idJuego"), rset.getString("Nombre"), rset.getString("genero"), rset.getString("consola"), rset.getString("autor"), rset.getString("Imagen"), rset.getString("nombre_autor"));
				  Autor a=new Autor(rset.getString("idAutor"),rset.getString("nombre_autor"));
				  out.println("<tr>" + "<td>"+a.getid()+"</td>"+ "<td>"+a.getNombre()+"</td>"+"<td>"+o.getNombre()+"</td>"+ "</tr>");
			  }
			  //out.println("<a href='/U5P02-Java-Catalogo/Catalogo'> Volver");
			  
			  
		  //OBRAS
		  }else {
		  //enlaces por parametro para la ordenacion
		  out.println("<tr>" + "<td>Nombre <a href='./Catalogo?orden=1'>&#9650  <a href='./MostrarCatalogo?orden=2'>&#9660 </td> " + "<td>Autor <a href='./MostrarCatalogo?orden=1'>&#9650  <a href='./MostrarCatalogo?orden=2'>&#9660 </td>"+ "</tr>" );
		  while (rset.next()) {
			
			Obra o=new Obra(rset.getString("idJuego"), rset.getString("Nombre"), rset.getString("genero"), rset.getString("consola"), rset.getString("autor"), rset.getString("Imagen"), rset.getString("nombre_autor"));
			out.println("<tr>" + 
			//nombre_obra parametro de mostrar obra
			"<td><a href='./MostrarObra?idJuego="+o.getIdJuego()+"'>"+o.getNombre()+"</a></td> "+
		    "<td><a href='./Catalogo?idAutor="+o.getAutor()+"'>"+ o.getNombreAutor() + "</td>" +
		    "</tr>");
		  }
		  }
		  out.println("</table>");
		  
		  //FORMULARIO BUSQUEDA
		  out.println("<form>"); 
		  out.println("<form action='/U5P02-Java-Catalogo/Catalogo' method='post'>"
					+ "Buscar por Obra:<input type='text' name='busqueda'  placeholder='Buscar'/><br>"
					+ "<input type='submit' name='enviar'><br><br>"
					+ "</form><br><br><br><br>");
		  
		  
		  
		  
		  // Paso 6: Desconexión
		  if (sentencia != null)
		    sentencia.close();
		  if (conn != null)
		    conn.close();
		} catch (Exception e) {
		  e.printStackTrace();
		}
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		out.println("<h4>Sesión iniciada como <a href='"+request.getRequestURI()+"/Cuenta'>" 
			+ usuario.getNombre_usuario() + "</a></h4>");
		out.println("</body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
