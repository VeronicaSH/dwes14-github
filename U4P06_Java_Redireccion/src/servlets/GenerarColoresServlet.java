package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GenerarColores")
public class GenerarColoresServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GenerarColoresServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext contexto = getServletContext();

		if (request.getAttribute("numero") != null) {

			int num1=(int)(Math.random()*255+1);
			request.setAttribute("numero1", num1);
		
			int num2=(int)(Math.random()*255+1);
			request.setAttribute("numero2", num2);
		
			int num3=(int)(Math.random()*255+1);
			request.setAttribute("numero3", num3);
		}else{
			response.sendRedirect(contexto.getContextPath() + "/Sorpresa");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/MostrarNumero");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
