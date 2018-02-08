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


@WebFilter(filterName="WrapFilter")
public class WrapFilter implements Filter {

    
    public WrapFilter() {
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html;UTF-8");
		ServletContext contexto=request.getServletContext();
		PrintWriter out = response.getWriter(); 
		out.println("<html><head><title>Visitas:" + contexto.getAttribute("contador") +"</title></head><body><center>Cabecera<hr />");
		
		
		chain.doFilter(request, response);
		out.println("<hr /><center>Page footer</body></html>"); 
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
