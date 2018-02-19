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


@WebServlet("/MostrarCuidador")
public class MostrarCuidadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MostrarCuidadorServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//inicializacion de la cabecera
		ServletContext contexto = getServletContext();
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/></head><body>");
		//parametro
		int idCuidador = 0;
		//errores de parametro
		boolean errorIdCuidadorAusente = false;
		boolean errorIdCuidadorFormato = false;
		boolean errorIdCuidadorInexistente = false;
		//recibe el parametro de la request
		String idCuidadorParametro = request.getParameter("idCuidador");
		//si el parametro es nulo
		if (idCuidadorParametro == null)
		  errorIdCuidadorAusente = true;
		//numero del id del cuidador
		else {
		  try {
		    idCuidador = Integer.parseInt(idCuidadorParametro);
		  } catch (Exception e) {
		    errorIdCuidadorFormato = true;
		  }
		}
		//si a ocurrido un error
		if (errorIdCuidadorAusente) {
		  out.println("<h3>Error: falta identificador de cuidador</h3>");
		} else if (errorIdCuidadorFormato) {
		  out.println("<h3>Error: el identificador de cuidador debe ser numérico</h3>");
		} else {
			Connection conn = null;
			Statement sentencia = null;
			try {
			  // Paso 1: Cargar el driver JDBC.
			  Class.forName("org.mariadb.jdbc.Driver").newInstance();

			  // Paso 2: Conectarse a la Base de Datos utilizando la clase Connection
			  String userName = "alumno";
			  String password = "alumno";
			  String url = "jdbc:mariadb://localhost:3306/animales";
			  conn = DriverManager.getConnection(url, userName, password);

			  // Paso 3: Crear la sentencia SQL
			  sentencia = conn.createStatement();

			  // Paso 4: Ejecutar la sentencia SQL a través de los objetos Statement
			  String consulta = "SELECT nombre from cuidador WHERE idCuidador="+idCuidador ;
			  ResultSet rset = sentencia.executeQuery(consulta);

			  // Paso 5: Mostrar resultados
			  if (!rset.isBeforeFirst() ) {    
			    out.println("<h3>Error: identificador de cuidador no válido</h3>");
			  }
			  else {
			    rset.next();
			    //id del cuidador
			    out.println("<p>Animales cuidados por " + rset.getString("nombre")+ ":</p>");
			    //consulta que coge los animales cuidados por ese idCuidador
			    String consultaAnimales = "SELECT animal.* FROM animal, cuida WHERE (animal.chip = cuida.chipAnimal) AND (cuida.idCuidador = '"+idCuidador+"')";
			    //ejecuta la consulta
			    rset = sentencia.executeQuery(consultaAnimales);
			    //si no hay resultados
			    if (!rset.isBeforeFirst() ) {    
			      out.println("<p>Este cuidador no cuida ningún animal</p>");
			    }
			    //muestra los resultados de la query
			    while (rset.next()) {
			      out.println("<li>" + rset.getString("nombre") + ", de la especie " + rset.getString("especie") + "</li>");
			    }
			    out.println("</ul>");
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
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
