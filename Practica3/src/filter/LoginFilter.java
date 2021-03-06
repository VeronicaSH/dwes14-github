package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

   
    public LoginFilter() {
        
    }

	
	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
				// definimos elementos que utilizaremos:
				HttpServletRequest request = (HttpServletRequest) req; // L1
				HttpServletResponse response = (HttpServletResponse) res; // L1
				ServletContext contexto = request.getServletContext(); 
				String uri = request.getRequestURI();
				HttpSession session = request.getSession(false); // si no existe no la creamos 
				String errorSesion = ""; 
				System.out.print("pasa");
				// comprobamos posibles errores:
			  	// a. Aviso: intento de acceso sin sesión iniciada
			  	// b. Aviso: existe sesión iniciada pero no contiene usuario
			  	// c. Aviso: existe sesión iniciada pero el usuario no existe en la base de datos
				// redirigir en caso de error, salvo en excepciones
				//todo lo que no termine en eso, redirige a login
				if( !errorSesion.isEmpty() && !(uri.endsWith("html") || uri.endsWith("Login"))){ 
					contexto.log(errorSesion + " - " + uri);
					response.sendRedirect(contexto.getContextPath()+"/Login");
				}else{
					chain.doFilter(request, response);
				}
			}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
