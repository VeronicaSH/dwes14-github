

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//el nombre de la URL
@WebServlet("/Bienvenida")
//creacion del servlet
public class PrimerServlet extends HttpServlet {
	//version del servlet
	private static final long serialVersionUID = 1L;
     
    public PrimerServlet() {
        super();
        
    }
    //request (peticion) info parametros o campos de formularios "lectura"
    //response(respuesta) codigo HTML "escritura"

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='UTF-8'/><title>Primer Servlet</title></head>");
		out.println("<body><h1>Primer servlet</h1>");
		out.println("<h3>Me llamo Veronica</h3>");
		out.println("<p>Ejecución de " + request.getContextPath() + "</p>" + "<br>");
		out.println("<a href=index.html>Volver</a>");
		out.println("</body></html>");
		out.close();
	}
	//una redirige a la otra 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
