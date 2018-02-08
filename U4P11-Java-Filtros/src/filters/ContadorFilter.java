package filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter(filterName="ContadorFilter")
public class ContadorFilter implements Filter {

    

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		PrintWriter out = response.getWriter();
		//recuperar el contesto de la request de los servlets
		ServletContext contexto=request.getServletContext();
		
		int contador = 0;
		//si no hay el atributo contador
		if(contexto.getAttribute("contador")==null) {
			//contador = new Integer (0);
			//creacion del atributo
			contexto.setAttribute("contador", 0);
		}else {
			//recogemos el atributo
			contador=(int) contexto.getAttribute("contador");
			//sumamos
			contador++;
			//devolvemos el atributo
			contexto.setAttribute("contador", contador);
			
			//System.out.println(contador);
			chain.doFilter(request, response);
			
		}
	}
		


	
	


	

	private ServletContext getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
