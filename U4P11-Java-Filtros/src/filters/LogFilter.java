package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
//anotacion para la redireccion al servlet de Saludo
//@WebFilter(urlPatterns = "/Saludo")
//@WebFilter(urlPatterns = "/*")
@WebFilter(filterName="FiltroDeRegistro")
public class LogFilter implements Filter {

    
    public LogFilter() {
       
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		if (request instanceof HttpServletRequest) 
			System.out.println("Petición:" + ((HttpServletRequest)request).getRequestURL().toString());
		PrintWriter out = response.getWriter();
		out.println("<p>Mensaje 1: Estamos aplicando el filtro de registro</p>");
		//response.setContentType("text/html;UTF-8");
		chain.doFilter(request, response);
		out.println("<p>Mensaje 2: De vuelta en el filtro tras ejecutar el resto de la cadena</p>");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
